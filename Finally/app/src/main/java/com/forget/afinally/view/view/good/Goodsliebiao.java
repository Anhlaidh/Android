package com.forget.afinally.view.view.good;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.forget.afinally.Mainweb;
import com.forget.afinally.R;
import com.forget.afinally.adapter.GoodsAdapter;
import com.forget.afinally.dao.GoodsDao;
import com.forget.afinally.entity.Goods;

import java.util.List;

public class Goodsliebiao extends AppCompatActivity {
    private Button back,search;
    private List listitem;
    private EditText editText;

    GoodsDao goodsDao=new GoodsDao(this);
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        String type=intent.getStringExtra("type");

        super.onCreate(savedInstanceState);

        setContentView(R.layout.goodsliebiao);
        back=(Button)findViewById(R.id.button3);
        search=(Button)findViewById(R.id.button4);
        editText=(EditText)findViewById(R.id.ET5);

        listitem=goodsDao.query(type);

        GoodsAdapter goodsAdapter=new GoodsAdapter(listitem,this);
        listView=(ListView)findViewById(R.id.lv) ;
        //点击搜索
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String goodsname=editText.getText().toString();
                Intent intent=new Intent(Goodsliebiao.this, GoodsSearch.class);
                intent.putExtra("goodsname",goodsname);
                startActivity(intent);

            }
        });
        //返回首页
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(Goodsliebiao.this, Mainweb.class);

                startActivity(intent2);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Goods goods = (Goods) listitem.get(position);
                int goodsid=goods.getGoodsid();
                Intent intent=new Intent(Goodsliebiao.this,GoodsDetailActivity.class);
                intent.putExtra("goodsid",goodsid);
                startActivity(intent);
            }
        });
        listView.setAdapter(goodsAdapter);
    }


}
