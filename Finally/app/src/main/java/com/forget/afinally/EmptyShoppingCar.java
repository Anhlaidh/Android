package com.forget.afinally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.forget.afinally.R;
public class EmptyShoppingCar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_shopping_car);
    }
    public void ShoppingCar_to_mainweb(View view){
        Intent intent = new Intent(EmptyShoppingCar.this,Mainweb.class);
        startActivity(intent);
    }
}
