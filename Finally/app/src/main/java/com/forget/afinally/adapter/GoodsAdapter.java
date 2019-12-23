package com.forget.afinally.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.forget.afinally.R;
import com.forget.afinally.entity.Goods;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

public class GoodsAdapter extends BaseAdapter {

    private Context context;//上下文
    private List<Goods> list;

    //构造方法
    public GoodsAdapter(List<Goods> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.listitem, null);
            viewHolder.tv_qc = (TextView) view.findViewById(R.id.ch7_qc);//获取title组件，用来显示商品名
            viewHolder.iv_Img = (ImageView) view.findViewById(R.id.ch7_iv);//获取iv_Img组件，用来显示商品图片
            viewHolder.tv_jc = (TextView) view.findViewById(R.id.ch7_jc);//获取tv_jc,用来显示介绍
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv_qc.setText(list.get(i).getGoodsname());//设置商品名
        viewHolder.tv_jc.setText(list.get(i).getGoodsintroduce());//设置商品介绍
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this.context));
        imageLoader.displayImage(list.get(i).getGoodsphoto(), viewHolder.iv_Img);//显示图片
//
        return view;
    }

    /**
     * 内部类
     */
    private class ViewHolder {
        TextView tv_qc, tv_jc;
        ImageView iv_Img;
    }
}