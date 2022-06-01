package com.example.finalexam3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Update_Activity extends AppCompatActivity {
    EditText ed_maNV, ed_tenNV, ed_ngaySinh, ed_soDT, ed_diaChi, ed_email;
     Button btn_Update, btn_Back;
     RadioButton rb_GTNam, rb_GTNu, rb_FED, rb_BED, rb_Tester;
     DBNhanvien dbNhanvien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        dbNhanvien = new DBNhanvien(Update_Activity.this);
        AnhXa();
        GetDataIntent();
        btn_Update.setOnClickListener(new View.OnClickListener() {
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
                if(dbNhanvien.updatenv(nhanvien) == false){
                    Toast.makeText(Update_Activity.this,"Đã cập nhật thông tin nhân viên mã: " + ma,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Update_Activity.this,"Không thể cập nhật thông tin nhân viên mã: " + ma,Toast.LENGTH_LONG).show();
                }
            }
        });
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(Update_Activity.this,Nav_Activity.class);
                startActivity(intentBack);
            }
        });
    }
    public void AnhXa()
    {
        ed_maNV = (EditText) findViewById(R.id.ed_maNV);
        ed_tenNV = (EditText) findViewById(R.id.ed_tenNV);
        ed_ngaySinh = (EditText) findViewById(R.id.ed_NgaySinh);
        ed_soDT = (EditText) findViewById(R.id.ed_soDT);
        ed_diaChi = (EditText) findViewById(R.id.ed_diaChi);
        ed_email = (EditText) findViewById(R.id.ed_email);
        rb_GTNam = (RadioButton) findViewById(R.id.rb_Nam);
        rb_GTNu = (RadioButton) findViewById(R.id.rb_Nu);
        rb_FED = (RadioButton) findViewById(R.id.rb_FED);
        rb_BED = (RadioButton) findViewById(R.id.rb_BED);
        rb_Tester = (RadioButton) findViewById(R.id.rb_T);
        btn_Update = (Button) findViewById(R.id.btn_Update);
        btn_Back = (Button) findViewById(R.id.btn_Back);
    }
    public void GetDataIntent()
    {
        Intent intent = getIntent();
        ed_maNV.setText(intent.getStringExtra("MaNV"));
        ed_tenNV.setText(intent.getStringExtra("TenNV"));
        ed_ngaySinh.setText(intent.getStringExtra("NgaySinh"));
        ed_soDT.setText(intent.getStringExtra("SoDT"));
        ed_diaChi.setText(intent.getStringExtra("DiaChi"));
        ed_email.setText(intent.getStringExtra("Email"));
        if(intent.getStringExtra("ChucVu").equals(rb_FED.getText().toString()))
        {
            rb_FED.setChecked(true);
        }
        else if(intent.getStringExtra("ChucVu").equals(rb_BED.getText().toString()))
        {
            rb_BED.setChecked(true);
        }
        else if(intent.getStringExtra("ChucVu").equals(rb_Tester.getText().toString()))
        {
            rb_Tester.setChecked(true);
        }
        if(intent.getStringExtra("GioiTinh").equals(rb_GTNam.getText().toString()))
        {
            rb_GTNam.setChecked(true);
        }
        else if(intent.getStringExtra("GioiTinh").equals(rb_GTNu.getText().toString()))
        {
            rb_GTNu.setChecked(true);
        }
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