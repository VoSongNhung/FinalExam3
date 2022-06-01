package com.example.finalexam3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalexam3.fragment.ListFragment;

public class Login_Activity extends AppCompatActivity {

    EditText ed_Username,ed_Password;
    Button btn_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed_Username.getText().toString().trim().equals("Admin") && ed_Password.getText().toString().trim().equals("1"))
                {
                    Intent intentBack = new Intent(Login_Activity.this,Nav_Activity.class);
                    intentBack.putExtra("User",ed_Username.getText().toString());
                    startActivity(intentBack);
                }
                else
                {
                    Toast.makeText(Login_Activity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void anhxa(){
        ed_Password = findViewById(R.id.ed_Password);
        ed_Username = findViewById(R.id.ed_Username);
        btn_Login = findViewById(R.id.btn_Login);
    }
}