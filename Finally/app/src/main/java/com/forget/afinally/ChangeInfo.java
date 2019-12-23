package com.forget.afinally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.forget.afinally.R;
public class ChangeInfo extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private EditText editTextAge;
    private EditText editTextPhone;
    private EditText editTextAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_info);
        editTextUsername = (EditText) findViewById(R.id.etUsername);
        editTextPassword = (EditText) findViewById(R.id.etPassword);
        editTextConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        editTextAge = (EditText) findViewById(R.id.etAge);
        editTextPhone = (EditText) findViewById(R.id.etPhone);
        editTextAddress = (EditText) findViewById(R.id.etAddress);
    }
    public void returnMainweb(View view){
        Intent intent = new Intent(ChangeInfo.this,Mainweb.class);
        //intent.setClass(Mainweb.this,Login.class);
        startActivity(intent);
    }
    public void commit(View view){
        if (editTextUsername.getText().toString().equals("")){
            Toast.makeText(this,"用户名不能为空",Toast.LENGTH_SHORT).show();
        }
        else if (editTextPassword.getText().toString().equals("")){
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(!(editTextPassword.getText().toString().equals(editTextConfirmPassword.getText().toString()))){
            Toast.makeText(this,"两次密码不相同",Toast.LENGTH_SHORT).show();
        }
        else if (editTextAge.getText().toString().equals("")){
            Toast.makeText(this,"年龄不能为空",Toast.LENGTH_SHORT).show();
        }
        else if (editTextPhone.getText().toString().equals("")){
            Toast.makeText(this,"电话不能为空",Toast.LENGTH_SHORT).show();
        }
        else if (editTextAddress.getText().toString().equals("")){
            Toast.makeText(this,"地址不能为空",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"提交成功",Toast.LENGTH_SHORT).show();
        }
    }
}
