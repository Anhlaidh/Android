package com.forget.afinally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpActivity extends AppCompatActivity {
    private TextView textView1,textView2,textView3,textView4,textView5;
    private EditText editText;
    private String city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
        new Thread(new MyHttpRequest()).start();
        textView1=(TextView)findViewById(R.id.weather);
        textView2=(TextView)findViewById(R.id.temperature);
        textView3=(TextView)findViewById(R.id.dressing_advice);
        textView4=(TextView)findViewById(R.id.wind);
        textView5=(TextView)findViewById(R.id.city);
        editText=(EditText)findViewById(R.id.weather_ET);
        textView5.setText(city);
    }
    public void ReturnMainweb(View view){
        Intent intent = new Intent(HttpActivity.this,Mainweb.class);
        startActivity(intent);
    }
    public void onClick(View view){
        city=editText.getText().toString();

        new Thread(new MyHttpRequest()).start();
    }
    private class MyHttpRequest implements Runnable{
        @Override
        public void run() {
            try {

                URL url=new URL("http://v.juhe.cn/weather/index?format=2&key=f421a4c763d10b6bf18c64957872a9cf&cityname="+URLEncoder.encode(city,"UTF-8"));
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setConnectTimeout(100000);
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.connect();
                if(connection.getResponseCode()!=HttpURLConnection.HTTP_BAD_REQUEST){
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String temp="";
                    final StringBuilder response=new StringBuilder();
                    while ((temp=bufferedReader.readLine())!=null){
                        response.append(temp);
                    }

                    Log.d(MyHttpRequest.class.toString(),response.toString());

                    JSONObject jsonObject=new JSONObject(response.toString());
                    String result =jsonObject.getString("result");
                    JSONObject jsonObect1=new JSONObject(result);
                    JSONObject today= jsonObect1.getJSONObject("today");

                    final String temperature =today.getString("temperature");
                    final String weather=today.getString("weather");
                    final String wind=today.getString("wind");
                    final String dressing_advice=today.getString("dressing_advice");
                    textView1.post(new Runnable() {
                        @Override
                        public void run() {
                            textView1.setText(weather);
                        }
                    });
                    textView2.post(new Runnable() {
                        @Override
                        public void run() {
                            textView2.setText(temperature);
                        }
                    });
                    textView3.post(new Runnable() {
                        @Override
                        public void run() {
                            textView3.setText(wind);
                        }
                    });
                    textView4.post(new Runnable() {
                        @Override
                        public void run() {
                            textView4.setText(dressing_advice);
                        }
                    });
                    bufferedReader.close();
                }
                connection.disconnect();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
