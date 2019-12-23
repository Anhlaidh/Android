package com.forget.afinally;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.forget.afinally.R;
import com.forget.afinally.dao.UserDao;

public class Login extends AppCompatActivity {
    private UserDao userDao;
    private EditText tvUsername;
    private EditText tvPassword;
    private ImageView ivLogin;
    private int flag = -10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        tvUsername = (EditText) findViewById(R.id.tvUsername);
        tvPassword = (EditText) findViewById(R.id.etPassword);
        ivLogin = (ImageView) findViewById(R.id.ivLogin);

        userDao = new UserDao(this);

//        ivLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String user = tvUsername.getText().toString();
//                String pass = tvPassword.getText().toString();
//                flag = userDao.login(user, pass);
//            }
//        });
    }
    public void Return(View view){
        Intent intent = new Intent(Login.this,Mainweb.class);
        startActivity(intent);
    }
    public void Login(View v) {
        String user = tvUsername.getText().toString();
        String pass = tvPassword.getText().toString();
        flag = userDao.login(user, pass);
        switch (flag) {
            case -1:
                Toast.makeText(this,"用户名不存在",Toast.LENGTH_SHORT).show();
                break;
            case 0:
                Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this,Loginning.class);
                startActivity(intent);
                break;
            case 1:
                Toast.makeText(this,"密码错误",Toast.LENGTH_SHORT).show();
                break;
        }
    }
//    public void Return(View view) {
//
//        if (userDao.login("","")=="") {
//
//        }
//        Intent intent = new Intent(Login.this,Mainweb.class);
//        //intent.setClass(Mainweb.this,Login.class);
//        startActivity(intent);
//    }
    public void toRegister(View view){
        Intent intent = new Intent(Login.this,Register.class);
        startActivity(intent);
    }
}
