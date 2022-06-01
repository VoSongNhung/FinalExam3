package com.example.finalexam3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class BaseAdapterList extends android.widget.BaseAdapter {
    private final Context context;
    private final List<Nhanvien> nhanvien;
    int layout;
    LayoutInflater inflter;
    public BaseAdapterList(Context context,List<Nhanvien> nhanvien,int layout){
        this.context =context;
        this.nhanvien = nhanvien;
        this.layout =layout;
        inflter = (LayoutInflater.from(context));
    }
    @Override
    public int getCount() {
        return nhanvien.size();
    }

    @Override
    public Object getItem(int i) {
        return nhanvien.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);
        TextView tv_Ten = (TextView) view.findViewById(R.id.tv_Ten);
        TextView tv_ChucVu = (TextView) view.findViewById(R.id.tv_Chucvu);
        TextView tv_Email = (TextView) view.findViewById(R.id.tv_Email);
        tv_Ten.setText("Tên nhân viên: " + String.valueOf(nhanvien.get(i).getTenNV()));
        tv_ChucVu.setText("Chức vụ: " + String.valueOf(nhanvien.get(i).getChucVu()));
        tv_Email.setText("Email: " + String.valueOf(nhanvien.get(i).getEmail()));
        return view;
    }
}
