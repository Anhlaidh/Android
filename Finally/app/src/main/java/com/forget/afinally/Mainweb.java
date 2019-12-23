package com.forget.afinally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.forget.afinally.dao.GoodsDao;
import com.forget.afinally.view.view.good.GoodsSearch;
import com.forget.afinally.view.view.good.Goodsliebiao;

public class Mainweb extends AppCompatActivity {
    private ImageView food;
    private ImageView mumandbaby;
    private ImageView skin;
    private ImageView spin;
    private ImageView snacks;
    private ImageView daily;
    private ImageView bt_search;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainweb);
        GoodsDao goodsDao=new GoodsDao(Mainweb.this);
        goodsDao.insert();
        food = (ImageView)findViewById(R.id.imageView1);
        mumandbaby = (ImageView)findViewById(R.id.imageView2);
        skin = (ImageView)findViewById(R.id.imageView3);
        spin = (ImageView)findViewById(R.id.imageView4);
        snacks = (ImageView)findViewById(R.id.imageView5);
        daily = (ImageView)findViewById(R.id.imageView6);
        bt_search=(ImageView) findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.ET1);
        food.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mainweb.this,Goodsliebiao.class);
                intent.putExtra("type","食品区");
                startActivity(intent);
            }
        });
        mumandbaby.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mainweb.this,Goodsliebiao.class);
                intent.putExtra("type","母婴区");
                startActivity(intent);
            }
        });
        skin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mainweb.this,Goodsliebiao.class);
                intent.putExtra("type","护肤品区");
                startActivity(intent);
            }
        });
        spin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mainweb.this,Goodsliebiao.class);
                intent.putExtra("type","纺织区");
                startActivity(intent);
            }
        });
        snacks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mainweb.this,Goodsliebiao.class);
                intent.putExtra("type","零食区");
                startActivity(intent);
            }
        });
        daily.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mainweb.this,Goodsliebiao.class);
                intent.putExtra("type","日用品区");
                startActivity(intent);
            }
        });
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String goodsname=editText.getText().toString();
                Intent intent=new Intent(Mainweb.this, GoodsSearch.class);
                intent.putExtra("goodsname",goodsname);
                startActivity(intent);

            }
        });
    }
    public void toShoppingCar(View view){
        Intent intent = new Intent(Mainweb.this,ShoppingCar.class);
        startActivity(intent);
    }
    public void toWeather(View view){
        Intent intent = new Intent(Mainweb.this,HttpActivity.class);
        startActivity(intent);
    }
    public void OnClickit(View view) {
        Intent intent = new Intent(Mainweb.this,Login.class);
        //intent.setClass(Mainweb.this,Login.class);
        startActivity(intent);
    }
    public void OnclickitToMainweb(View view){
//        Intent intent = new Intent(Mainweb.this,Mainweb.class);
//        //intent.setClass(Mainweb.this,Login.class);
//        startActivity(intent);
    }


}
