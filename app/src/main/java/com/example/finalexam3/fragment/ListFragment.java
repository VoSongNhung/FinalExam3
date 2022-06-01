package com.example.finalexam3.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalexam3.BaseAdapterList;
import com.example.finalexam3.DBNhanvien;
import com.example.finalexam3.Nhanvien;
import com.example.finalexam3.R;
import com.example.finalexam3.Update_Activity;

import java.util.List;

public class ListFragment extends Fragment {
    ArrayAdapter<Nhanvien> adapter;
    ListView lv;
    DBNhanvien dbNhanvien;
    int vitri;
    BaseAdapterList baseAdapterList;
    String Intent_maNV,Intent_tenNV,Intent_chucVu,
            Intent_diaChi,Intent_email,Intent_soDT,
            Intent_ngaySinh, Intent_gioiTinh;
    List<Nhanvien> list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dbNhanvien = new DBNhanvien(getActivity());
        View view = inflater.inflate(R.layout.layout_fragmentlist, container, false);
        lv = (ListView) view.findViewById(R.id.lv_Nhanvien);
        list = dbNhanvien.getAllPeople();
        /*adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, list);
       lv.setAdapter(adapter);*/
        baseAdapterList = new BaseAdapterList(getActivity().getApplicationContext(), list,R.layout.layout_baseadapder_list);
        lv.setAdapter(baseAdapterList);
       registerForContextMenu(lv);
       lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               vitri = i;
               Nhanvien nhanvien = (Nhanvien) adapterView.getItemAtPosition(vitri);
               Intent_maNV = nhanvien.getMaNV();
               Intent_tenNV = nhanvien.getTenNV();
               Intent_ngaySinh = nhanvien.getNgaySinh();
               Intent_gioiTinh = nhanvien.getGioiTinh();
               Intent_chucVu = nhanvien.getChucVu();
               Intent_soDT = nhanvien.getSoDT() + "";
               Intent_diaChi = nhanvien.getDiaChi();
               Intent_email = nhanvien.getEmail();
               return false;
           }
       });
        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.menu_listnv,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.xoa:
                int resultdl = dbNhanvien.delete(Intent_maNV);
                /*if (resultdl == 0)
                {
                    adapter.remove(adapter.getItem(vitri));
                    list.clear();
                    list.addAll(dbNhanvien.getAllPeople());
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getActivity(),"Đã xóa nhân viên có mã: " + Intent_maNV,Toast.LENGTH_LONG).show();
                }*/
                if (resultdl == 0)
                {
                    list.clear();
                    list.addAll(dbNhanvien.getAllPeople());
                    baseAdapterList.notifyDataSetChanged();
                    Toast.makeText(getActivity(),"Đã xóa nhân viên có mã: " + Intent_maNV,Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.capnhat:
                Intent intent = new Intent(getActivity(), Update_Activity.class);
                intent.putExtra("MaNV",Intent_maNV);
                intent.putExtra("TenNV",Intent_tenNV);
                intent.putExtra("NgaySinh",Intent_ngaySinh);
                intent.putExtra("GioiTinh",Intent_gioiTinh);
                intent.putExtra("ChucVu",Intent_chucVu);
                intent.putExtra("SoDT",Intent_soDT);
                intent.putExtra("DiaChi",Intent_diaChi);
                intent.putExtra("Email",Intent_email);
                startActivity(intent);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
