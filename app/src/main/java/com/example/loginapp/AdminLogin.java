package com.example.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    private TextView studentText;
    private EditText uname, pass;
    private Button adminlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        if (getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        studentText = findViewById(R.id.studentText);
        uname = findViewById(R.id.editTextUser);
        pass = findViewById(R.id.editTextPass);
        adminlogin = findViewById(R.id.buttonContinue);

        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(uname.getText().toString(),pass.getText().toString());
            }
        });

        studentText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private  void  validate(String userName,String userPassword){
        if((userName.equals("admin"))&&(userPassword.equals("12345"))){
            Intent intent=new Intent(AdminLogin.this,AdminDashboard.class);
            startActivity(intent);
        }else if (TextUtils.isEmpty(userName)){
            uname.setError("Username is required");
            uname.requestFocus();
            return;
        }else if (TextUtils.isEmpty(userPassword)){
            pass.setError("Password is required");
            pass.requestFocus();
            return;
        }else {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter valid credentials", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
