package com.forget.afinally.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.forget.afinally.DButil.DBHelper;
import com.forget.afinally.DButil.MydbOpenHelper;
import com.forget.afinally.entity.User;

public class UserDao {
    private MydbOpenHelper mydbOpenHelper;

    public UserDao(Context context) {
        mydbOpenHelper = new MydbOpenHelper(context);
    }

    public void add(User user) {
        SQLiteDatabase db = mydbOpenHelper.getWritableDatabase();
        String sql = "insert into u_user values (?,?,?,?,?)";
        db.execSQL(sql, new String[]{
                user.getUsername(), user.getPassword(), user.getAge(), user.getPhone(),user.getAddress()
        });
        db.close();
    }
    public void update(User user){
        SQLiteDatabase db = mydbOpenHelper.getWritableDatabase();
        String sql = "update u_user set name=?,password=?,age=?,phone=?,address=?";
        db.execSQL(sql, new Object[]{
                user.getUsername(), user.getPassword(), user.getAge(), user.getPhone(),user.getAddress()
        });
        db.close();
    }
//    public void delete(String...id) {
//        if (id.length > 0) {
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < id.length; i++) {
//                sb.append('?').append(',');
//                sb.deleteCharAt(sb.length()-1);
//                SQLiteDatabase sqLiteDatabase=mydbOpenHelper.getWritableDatabase();
//                String sql="delete from u_user where username in ('+sb+')";
//                sqLiteDatabase.execSQL(sql,(Object[]) id);
//            }
//        }
//    }
//    public void deleteAll(){
//        SQLiteDatabase sqLiteDatabase=mydbOpenHelper.getWritableDatabase();
//        String sql = "delete from u_user";
//        sqLiteDatabase.execSQL(sql);
//    }
    public int login(String user,String pass){
        User user1 = find(user);
        Log.d("UserDao's pass",pass);
        if(user1==null){
            Log.d("login","用户不存在");
            return -1;
        } else if(user1.getPassword().equals(pass)){
            Log.d("login","登录成功");
            return 0;
        } else{
            Log.d("login","密码错误");
            return 1;
        }
    }
//    public  void update(User user){
//        SQLiteDatabase db =mydbOpenHelper.getWritableDatabase();
//        String sql="update u_user set name=?,age=?,tall=?where id=?";
//        db.replace()
//        SQLiteDatabase  mDatabase = new DBHelper(this).getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name","update");
//        contentValues.put("gender",1);
//        contentValues.put("number","201804111048");
//        contentValues.put("score","100");
//
//        mDatabase.update(DBHelper.,contentValues,"name = ?",new String[]{"lemon"});
//    }

    public User find(String username){
        SQLiteDatabase db=mydbOpenHelper.getWritableDatabase();
        String sql="select * from u_user where username=?";
        Cursor cursor=db.rawQuery(sql,new String[]{
                username
        });
//        Log.d("UserDao",""+cursor.moveToFirst());
//        Log.d("UserDao",cursor.getString(cursor.getColumnIndex("username")));
//        Log.d("UserDao",cursor.getString(cursor.getColumnIndex("password")));
//        Log.d("UserDao",cursor.getString(cursor.getColumnIndex("age")));
//        Log.d("UserDao",cursor.getString(cursor.getColumnIndex("phone")));
//        Log.d("UserDao",cursor.getString(cursor.getColumnIndex("address")));
        if(cursor.moveToFirst()){
            return  new User(
                    cursor.getString(cursor.getColumnIndex("username")),
                    cursor.getString(cursor.getColumnIndex("password")),
                    cursor.getString(cursor.getColumnIndex("age")),
                    cursor.getString(cursor.getColumnIndex("phone")),
                    cursor.getString(cursor.getColumnIndex("address"))
            );
        }
        return null;
    }

//    public List<User> getAllData(){
//        SQLiteDatabase db=mydbOpenHelper.getWritableDatabase();
//        List<User> user=new ArrayList<User>();
//        String sql="select * from u_user";
//        Cursor cursor=db.rawQuery(sql, new String[]{
//        });
//        while(cursor.moveToNext()){
//            user.add(new User(cursor.getString(cursor.getColumnIndex("Username")),
//                    cursor.getString(cursor.getColumnIndex("Password")),
//                    cursor.getString(cursor.getColumnIndex("Age")),
//                    cursor.getString(cursor.getColumnIndex("Phone")),
//                    cursor.getString(cursor.getColumnIndex("Address")))
//            );
//        }
//        return user;
//    }
//
//    public  Cursor select(){
//        SQLiteDatabase sqLiteDatabase=mydbOpenHelper.getReadableDatabase();
//        Cursor cursor=sqLiteDatabase.query("u_user",null,null,null,null,null,"id desc");
//        return  cursor;
//    }

}
