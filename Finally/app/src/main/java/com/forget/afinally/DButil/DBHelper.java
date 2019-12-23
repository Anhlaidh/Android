package com.forget.afinally.DButil;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * @ClassName DBHelper
 * @Description DBhelper
 * @Author Anhlaidh
 * @DATE 2019/12/23 0023 21:11
 * @Version
 */
public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    private Context _context;
    private static final int VERSION = 1;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
        _context = context;

    }

    public DBHelper(Context context, String name) {
        this(context, name, null, VERSION);
        db = this.getReadableDatabase();
        // File file = new File(Environment.getExternalStorageDirectory()
        // + "/mypackage" + "/" + name + ".sqllite");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    public void insertTmpData() {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("db upgrade");
    }

    // 数据库的查询函数
    public Cursor rawQuery(String sql) {
        return db.rawQuery(sql, null);
    }

    public boolean execSQL(String sql) {
        db.execSQL(sql);
        return true;
    }

    public boolean execSQL(String sql, boolean Throw) throws SQLException {
        db.execSQL(sql);
        return true;
    }

    // 封装系统的执行sql语句的函数
    public boolean execSQL(String sql, Object[] object) {
        db.execSQL(sql, object);
        return true;
    }

    public void beginTransaction() {
        db.beginTransaction();
    }

    public void setTransactionSuccessful() {
        db.setTransactionSuccessful();
    }

    public void endTransaction() {
        db.endTransaction();
    }

    public void close() {
        db.close();
    }
}
