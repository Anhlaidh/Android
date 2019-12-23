package com.forget.afinally.dao;

import android.content.Context;
import android.database.Cursor;

import com.forget.afinally.DButil.MyOpenHelper;
import com.forget.afinally.entity.Goods;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GoodsDao {
    private MyOpenHelper dbHelp_goods;//数据库
    //private List<Goods> listGoods=new ArrayList<>();
    private Context context;

    public GoodsDao(Context context) {
        this.context=context;
    }


    public void insert() {
        dbHelp_goods=new MyOpenHelper(context);
        dbHelp_goods.db=dbHelp_goods.getWritableDatabase();
        dbHelp_goods.db.delete(dbHelp_goods.TABLE_NAME,null,null);
        //food
        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price') values ('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577707728&di=9c99bca2ee945a5b7e5ba4ea1202393e&imgtype=jpg&er=1&src=http%3A%2F%2Fpic.51yuansu.com%2Fpic3%2Fcover%2F01%2F24%2F98%2F5922b17ae0793_610.jpg','猪肉脯','食品区','01','1.0')");
        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price') values ('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577113040323&di=7371a683c99f901de72d4eebe1ba751f&imgtype=0&src=http%3A%2F%2Fp0.meituan.net%2Fwaimaipoi%2F2db00b47d8144be9de9ce781fdad9164403936.jpg','鸭脖','食品区','02','15.0')");
        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price') values ('https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=740484109,3292231086&fm=26&gp=0.jpg','鸡心','食品区','03','4.0')");
        //2
        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price') values ('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1546509320&di=5d7736b38003ccc64771af9927ae570c&imgtype=jpg&er=1&src=http%3A%2F%2Fimg011.hc360.cn%2Fhb%2FMTQ2Mjk0MDU1Nzc5OC0xMjgzMjQ0OTk5.jpg','奶嘴','母婴区','01','10.0')");
        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price') values ('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545914621314&di=5f3158b0e79d36376d24276ad6efb368&imgtype=0&src=http%3A%2F%2Fimg13.360buyimg.com%2FpopWaterMark%2Fjfs%2Ft1504%2F310%2F315709086%2F215380%2Fc3ad77e6%2F55713980N9776cbaa.jpg','尿不湿','母婴区','02','30.0')");

        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price') values ('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545914640347&di=c193eace1f86b030632db8d4a79dd437&imgtype=0&src=http%3A%2F%2Fwww.beingmate.com%2FUploads%2FImage%2FImage%2F2017-09%2F59b22bc6e76b7.jpg','奶粉','母婴区','03','60.0')");
        //3
        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price') values ('https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=108375021,2991112359&fm=26&gp=0.jpg','护手霜','护肤品区','01','30.0')");

        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price') values ('https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3516004609,1850003974&fm=26&gp=0.jpg','面膜','护肤品区','02','40.0')");

        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price') values ('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1546509426&di=546b4b868a5ce2b05e882793956f8ea9&imgtype=jpg&er=1&src=http%3A%2F%2Fimage3.suning.cn%2Fb2c%2Fcatentries%2F000000000125700430_2_800x800.jpg','雪花膏','护肤品区','03','20.0')");
        //4
        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price') values ('https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2276282280,2487835111&fm=26&gp=0.jpg','薯片','零食区','01','20.0')");

        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price')  values ('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1546509464&di=81f1a2858d258216f8a4e5458abe55ab&imgtype=jpg&er=1&src=http%3A%2F%2Fgss0.baidu.com%2F9fo3dSag_xI4khGko9WTAnF6hhy%2Fzhidao%2Fpic%2Fitem%2Fa71ea8d3fd1f4134256aca202d1f95cad1c85e0b.jpg','饼干','零食区','02','49.0')");
        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price')  values ('https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2377506483,3850279828&fm=26&gp=0.jpg','饮料','零食区','03','4.0')");
        //5
        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price') values ('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1546509505&di=ece9ae48e8214daa2ec9c46633587bbf&imgtype=jpg&er=1&src=http%3A%2F%2Fimage.suning.cn%2Fcontent%2Fcatentries%2F00000000010532%2F000000000105322739%2Ffullimage%2F000000000105322739_1f.jpg','手套','纺织区','01','25.0')");

        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price')  values ('https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=167736080,3007813028&fm=26&gp=0.jpg','围巾','纺织区','02','15.0')");
        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price')  values ('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545914885508&di=88e4fff8902dbeae5ea5aaad83f07d26&imgtype=0&src=http%3A%2F%2Fwww.cdhongfu.com%2Fimg%2Fi2%2FTB1Od6OFVXXXXbcXVXXXXXXXXXX_%2521%25210-item_pic.jpg','毛衣','纺织区','03','105.0')");
        //6
        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price') values ('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545914900549&di=b83166519e23f3922da82c806e4b0e6d&imgtype=0&src=http%3A%2F%2Fimg.hb.aicdn.com%2F858c8c8c8ce747e200c70bac7b5087b5df0d6311830205-fY2kCv_fw658','牙膏','日用品区','01','10.0')");

        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price')  values ('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1546509641&di=e0066b16744f0dfdcdedcf471fbf43c6&imgtype=jpg&er=1&src=http%3A%2F%2Fimg000.hc360.cn%2Fm6%2FM0F%2F7A%2FFE%2FwKhQoVajSD-EPRC9AAAAAHWfJ8s906.jpg','牙刷','日用品区','02','20.0')");
        dbHelp_goods.db.execSQL("insert into " + dbHelp_goods.TABLE_NAME +
                "('photo','title','type','introduce','price')  values ('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1546509714&di=4e3d81a0c399818c734629861c1b048f&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.yibao9.com%2FYX_UpFile%2FBig%2F20161129111337.jpg','肥皂','日用品区','03','15.0')");

    }

    //按照ID查询商品
    public Goods  queryGoodsById(int id){
        dbHelp_goods=new MyOpenHelper(context);
        dbHelp_goods.db=dbHelp_goods.getWritableDatabase();
        Goods goods=null;
        List<Goods> arrayList=new ArrayList<Goods>();

        Cursor c=dbHelp_goods.db.query(dbHelp_goods.TABLE_NAME,null,"goodsid=?",new String[]{id+""},null,null,null,null);

        if(c!=null){
            while(c.moveToNext()) {
                String imageURl=c.getString(c.getColumnIndex("photo"));
                String title=c.getString(c.getColumnIndex("title"));
                String introduce=c.getString(c.getColumnIndex("introduce"));
                String type=c.getString(c.getColumnIndex("type"));
                double price=c.getDouble(c.getColumnIndex("price"));
                goods = new Goods(id, imageURl, title, price,type,introduce);
                return goods;
            }

        }
        return null;
    }
    //按照类型查询商品

    public List<Goods> query(String type){
        dbHelp_goods=new MyOpenHelper(context);
        dbHelp_goods.db=dbHelp_goods.getWritableDatabase();
        List listGoods=new ArrayList();
        Cursor c=dbHelp_goods.db.query(dbHelp_goods.TABLE_NAME,null,"type=?",new String[]{type},null,null,null,null);
        if(c!=null){
            while(c.moveToNext()){
                int goodsid=c.getInt(c.getColumnIndex("goodsid"));
                String imageURl=c.getString(c.getColumnIndex("photo"));
                String title=c.getString(c.getColumnIndex("title"));
                String introduce=c.getString(c.getColumnIndex("introduce"));
                double price=c.getDouble(c.getColumnIndex("price"));
                Goods goods=new Goods(goodsid,imageURl,title,price,type,introduce);
                listGoods.add(goods);
            }
            return listGoods;
        }
        else{
            return null;
        }

    }

    public List<Goods> searchGoods(String key) {
        dbHelp_goods=new MyOpenHelper(context);
        dbHelp_goods.db=dbHelp_goods.getWritableDatabase();
        List<Goods> result = new LinkedList<Goods>();
        Cursor c = dbHelp_goods.db.query(dbHelp_goods.TABLE_NAME, null, "title  like ?", new String[]{"%" + key + "%"}, null, null, null, null);
        //Cursor c = dbHelp_goods.db.query(dbHelp_goods.TABLE_NAME, null, "title=?", new String[]{goodsName}, null, null, null, null);
        //String current_sql_sel = "SELECT  * FROM "+dbHelp_goods.TABLE_NAME +" where title like ?";
        //Cursor c = dbHelp_goods.db.rawQuery(current_sql_sel, new String[]{"%"+goodsName+"%"});

        if (c != null) {
            while (c.moveToNext()) {
                int goodsid = c.getInt(c.getColumnIndex("goodsid"));
                String goodsname = c.getString(c.getColumnIndex("title"));
                String imageURl = c.getString(c.getColumnIndex("photo"));
                String introduce = c.getString(c.getColumnIndex("introduce"));
                double price = c.getDouble(c.getColumnIndex("price"));
                String type=c.getString(c.getColumnIndex("type"));
                Goods goods = new Goods(goodsid, imageURl, goodsname, price, type, introduce);
                result.add(goods);
            }

        }
        return result;
    }
    public void deleteAll(){
        dbHelp_goods.db.delete(dbHelp_goods.TABLE_NAME,null,null);
    }
}
