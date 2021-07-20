package bean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;


import androidx.annotation.Nullable;

import bean.User;

public class Myslq extends SQLiteOpenHelper {//数据库帮助类
    private static final String NAME="user.db";
    private static final String TABLE_NAME="user";

    private static String sql="create table if not exists "+TABLE_NAME+
            "(u_id Integer primary key autoincrement," +
            "name varchar(30) not null," +
            "pass varchar(50) not null," +
            "email varcher(30) not null," +
            "generate verchar(2) not null)";

    public Myslq(Context context){
        super(context,NAME,null,2);
    }

    public Myslq(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);//文本、数据库名字、工厂、版本
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);//方法执行SQL语句,创建一个数据库
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Long InsertUser(User user){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put("name",user.getUser());
        value.put("pass",user.getPass());
        value.put("email",user.getEmail());
        value.put("generate",user.getGenerate());
        return  db.insert(TABLE_NAME,null,value);
    }
    public User Query(String name){
        User use=null;
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.query(TABLE_NAME,null,"name like ?",new String[]{name},null,null,null);
        while(cursor.moveToNext()) {
            String nameString = cursor.getString(cursor.getColumnIndex("name"));
            String password = cursor.getString(cursor.getColumnIndex("pass"));
            use = new User(nameString, password);
        }
        return use;
    }
    public User ReQuery(String email){
        User user=null;
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.query(TABLE_NAME,null,"email like ?",new String[]{email},null,null,null);
        while(cursor.moveToNext()) {
            String emailString=cursor.getColumnName(cursor.getColumnIndex("email"));
            String nameString = cursor.getString(cursor.getColumnIndex("name"));
            String password = cursor.getString(cursor.getColumnIndex("pass"));
            user = new User(nameString, password,emailString);
        }
        return user;
    }
}
