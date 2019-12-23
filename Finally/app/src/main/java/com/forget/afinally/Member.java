package com.forget.afinally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.forget.afinally.DButil.DBHelper;
import com.forget.afinally.R;
import com.forget.afinally.dao.UserDao;
import com.forget.afinally.entity.User;

public class Member extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText age;
    private EditText phone;
    private EditText address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        age = (EditText)findViewById(R.id.password);
        phone = (EditText)findViewById(R.id.phone);
        address = (EditText)findViewById(R.id.address);
    }
    public void MyOnclick(View view){
        Intent intent = new Intent(Member.this,Mainweb.class);
        startActivity(intent);
    }
    public void change(View view){
        UserDao userDao=new UserDao(Member.this);
        User user=new User(username.getText().toString(),password.getText().toString(),age.getText().toString(),phone.getText().toString(),address.getText().toString());
        userDao.update(user);
        DBHelper dbHelper = new DBHelper(this, "test.db", null, 2);


    }
}
