package com.forget.afinally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.forget.afinally.view.view.weather.Weather;

public class Loginning extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logining);
    }

    public void Tologin(View view){
        Intent intent = new Intent(Loginning.this,Login.class);
        startActivity(intent);
    }
    public void Tomainweb(View view){
        Intent intent = new Intent(Loginning.this,Mainweb.class);
        startActivity(intent);
    }
    public void Toweather(View view){
        Intent intent = new Intent(Loginning.this,Weather.class);
        startActivity(intent);
    }
    public void ToShoppingcar(View view){
        Intent intent = new Intent(Loginning.this,ShoppingCar.class);
        startActivity(intent);
    }
    public void message(View view){
        Intent intent = new Intent(Loginning.this,Member.class);
        startActivity(intent);
    }
}
