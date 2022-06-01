package com.example.finalexam3.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalexam3.DBNhanvien;
import com.example.finalexam3.Nhanvien;
import com.example.finalexam3.R;

public class AddFragment extends Fragment {
     EditText ed_maNV, ed_tenNV, ed_ngaySinh, ed_soDT, ed_diaChi, ed_email;
     Button btn_Add;
     RadioButton rb_GTNam, rb_GTNu, rb_FED, rb_BED, rb_Tester;
     DBNhanvien dbNhanvien;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragmentadd, container, false);
        dbNhanvien = new DBNhanvien(getActivity());
        ed_maNV = (EditText) view.findViewById(R.id.ed_maNV);
        ed_tenNV = (EditText) view.findViewById(R.id.ed_tenNV);
        ed_ngaySinh = (EditText) view.findViewById(R.id.ed_NgaySinh);
        ed_soDT = (EditText) view.findViewById(R.id.ed_soDT);
        ed_diaChi = (EditText) view.findViewById(R.id.ed_diaChi);
        ed_email = (EditText) view.findViewById(R.id.ed_email);
        rb_GTNam = (RadioButton) view.findViewById(R.id.rb_Nam);
        rb_GTNu = (RadioButton) view.findViewById(R.id.rb_Nu);
        rb_FED = (RadioButton) view.findViewById(R.id.rb_FED);
        rb_BED = (RadioButton) view.findViewById(R.id.rb_BED);
        rb_Tester = (RadioButton) view.findViewById(R.id.rb_T);
        btn_Add = (Button) view.findViewById(R.id.btn_Add);
        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma = ed_maNV.getText().toString();
                String ten = ed_tenNV.getText().toString();
                String ngaysinh = ed_ngaySinh.getText().toString();
                String gioitinh = GioiTinh();
                String cv = ChucVu();
                int sdt = Integer.parseInt(ed_soDT.getText().toString());
                String dc = ed_diaChi.getText().toString();
                String mail = ed_email.getText().toString();
                Nhanvien nhanvien = new Nhanvien(ma, ten, ngaysinh, gioitinh, cv, sdt, dc, mail);
                if(dbNhanvien.addnv(nhanvien) == false){
                    Toast.makeText(getActivity(),"Đã thêm nhân viên mới",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getActivity(),"Không thể thêm nhân viên này",Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
    private String GioiTinh() {
        String GioiTinh = null;
        if (this.rb_GTNam.isChecked()) {
            GioiTinh = this.rb_GTNam.getText().toString();
        } else if (this.rb_GTNu.isChecked()) {
            GioiTinh = this.rb_GTNu.getText().toString();
        }
        return GioiTinh;
    }

    private String ChucVu() {
        String ChucVu = null;
        if (this.rb_FED.isChecked()) {
            ChucVu = this.rb_FED.getText().toString();
        } else if (this.rb_BED.isChecked()) {
            ChucVu = this.rb_BED.getText().toString();
        } else if (this.rb_Tester.isChecked()) {
            ChucVu = this.rb_Tester.getText().toString();
        }
        return ChucVu;
    }
}
