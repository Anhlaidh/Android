package com.forget.afinally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.forget.afinally.R;
public class My extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my);
    }
    public void toLogin(View view) {
        Intent intent = new Intent(My.this,Login.class);
        //intent.setClass(Mainweb.this,Login.class);
        startActivity(intent);
    }
    public void toMainweb(View view) {
        Intent intent = new Intent(My.this,Mainweb.class);
        //intent.setClass(Mainweb.this,Login.class);
        startActivity(intent);
    }
}
