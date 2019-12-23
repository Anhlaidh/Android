package com.forget.afinally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.forget.afinally.adapter.ShoppingAdapter;
import com.forget.afinally.common.Shopping;
import com.forget.afinally.dao.GoodsDao;

import java.util.List;

public class ShoppingCar extends AppCompatActivity {
    private TextView textView;
    private ListView listView;
    private List listitem;
    private ShoppingAdapter shoppingAdapter;
    GoodsDao goodsDao=new GoodsDao(this);
    private double total = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        String type=intent.getStringExtra("type");
        setContentView(R.layout.shopping_car1);
        textView = (TextView) findViewById(R.id.total_price);
        listView = (ListView)findViewById(R.id.carlistview);
        listitem = Shopping.products;
        shoppingAdapter=new ShoppingAdapter(listitem,this);
        listView.setAdapter(shoppingAdapter);
        getTotal();
    }

    public void getTotal() {
        for (int i=0;i<Shopping.products.size();i++){
            total = total + Shopping.products.get(i).getGoodsprice();
        }
        textView.setText(""+total);
    }

    public void clear(View view){
        total = 0.0;
        textView.setText(""+total);
        Shopping.products.clear();
        shoppingAdapter.notifyDataSetChanged();
    }
}
