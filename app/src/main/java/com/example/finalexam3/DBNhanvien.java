package com.example.finalexam3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class DBNhanvien extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DSNhanVien";
    private Context context;

    public DBNhanvien(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String create_DB = "create table NhanVien(maNV nvarchar(20) primary key, tenNV text(50), ngaySinh text(50), gioiTinh text(50),chucVu text(50),soDT int,diaChi text(50),email text(50))";
    sqLiteDatabase.execSQL(create_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void add(Nhanvien nhanvien){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maNV",nhanvien.getMaNV());
        contentValues.put("tenNV",nhanvien.getTenNV());
        contentValues.put("ngaySinh",nhanvien.getNgaySinh());
        contentValues.put("gioiTinh",nhanvien.getGioiTinh());
        contentValues.put("chucVu",nhanvien.getChucVu());
        contentValues.put("soDT",nhanvien.getSoDT());
        contentValues.put("diaChi",nhanvien.getDiaChi());
        contentValues.put("email",nhanvien.getEmail());
        sqLiteDatabase.insert("NhanVien",null,contentValues);
        sqLiteDatabase.close();
    }
    public List<Nhanvien> getAllPeople() {
        List<Nhanvien> nhanvienList = new ArrayList<Nhanvien>();
        /*Select All Query*/
        String selectQuery = "SELECT  * FROM NhanVien";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Nhanvien nhanvien = new Nhanvien();
                nhanvien.setMaNV(cursor.getString(0));
                nhanvien.setTenNV(cursor.getString(1));
                nhanvien.setNgaySinh(cursor.getString(2));
                nhanvien.setGioiTinh(cursor.getString(3));
                nhanvien.setChucVu(cursor.getString(4));
                nhanvien.setSoDT(cursor.getInt(5));
                nhanvien.setDiaChi(cursor.getString(6));
                nhanvien.setEmail(cursor.getString(7));
                nhanvienList.add(nhanvien);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return nhanvienList;
    }
    public List<Nhanvien> getPersonByID(String ma){
        List<Nhanvien> ListNhanVien = new ArrayList<Nhanvien>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from NhanVien where maNV = '"+ ma +"'";
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor != null)
            cursor.moveToFirst();
        Nhanvien nhanvien = new Nhanvien();
                nhanvien.setMaNV(cursor.getString(0));
                nhanvien.setTenNV(cursor.getString(1));
                nhanvien.setNgaySinh(cursor.getString(2));
                nhanvien.setGioiTinh(cursor.getString(3));
                nhanvien.setChucVu(cursor.getString(4));
                nhanvien.setSoDT(cursor.getInt(5));
                nhanvien.setDiaChi(cursor.getString(6));
                nhanvien.setEmail(cursor.getString(7));
                ListNhanVien.add(nhanvien);
        cursor.close();
        db.close();
        return ListNhanVien;
    }
    public List<Nhanvien> getPersonByName(String name){
        List<Nhanvien> SearchList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM NhanVien Where tenNV LIKE '%"+ name +"%'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Nhanvien nhanvien = new Nhanvien();
                nhanvien.setMaNV(cursor.getString(0));
                nhanvien.setTenNV(cursor.getString(1));
                nhanvien.setNgaySinh(cursor.getString(2));
                nhanvien.setGioiTinh(cursor.getString(3));
                nhanvien.setChucVu(cursor.getString(4));
                nhanvien.setSoDT(cursor.getInt(5));
                nhanvien.setDiaChi(cursor.getString(6));
                nhanvien.setEmail(cursor.getString(7));
                SearchList.add(nhanvien);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return SearchList;
    }
    public int delete(String manv) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("NhanVien", "maNV"+"= ?",
                new String[] { String.valueOf(manv) });
        db.close();
        return 0;
    }
    public boolean addnv(Nhanvien nhanvien){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("maNV", nhanvien.getMaNV());
        values.put("tenNV", nhanvien.getTenNV());
        values.put("ngaySinh",nhanvien.getNgaySinh());
        values.put("gioiTinh",nhanvien.getGioiTinh());
        values.put("chucVu", nhanvien.getChucVu());
        values.put("soDT", nhanvien.getSoDT());
        values.put("diaChi", nhanvien.getDiaChi());
        values.put("email", nhanvien.getEmail());
        db.insert("NhanVien",null,values);
        db.close();
        return false;
    }
    public boolean updatenv(Nhanvien nhanvien)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("maNV", nhanvien.getMaNV());
        values.put("tenNV", nhanvien.getTenNV());
        values.put("ngaySinh",nhanvien.getNgaySinh());
        values.put("gioiTinh",nhanvien.getGioiTinh());
        values.put("chucVu", nhanvien.getChucVu());
        values.put("soDT", nhanvien.getSoDT());
        values.put("diaChi", nhanvien.getDiaChi());
        values.put("email", nhanvien.getEmail());
        db.update("NhanVien",values,"maNV = ?",new String[]{String.valueOf(nhanvien.getMaNV())});
        db.close();
        return false;
    }
}
