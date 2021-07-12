package com.example.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyProvider extends ContentProvider {
    public static final int TABLE_DIR=0;
    public static final int TABLE_ITEM=1;
    public static final int TABLE2_DIR=2;
    public static final int TABLE2_ITEM=3;
    private static UriMatcher uriMatcher;//管理对象
    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.app.provider","table1",TABLE_DIR);
        uriMatcher.addURI("com.example.app.provider","table1",TABLE_ITEM);
        uriMatcher.addURI("com.example.app.provider","table2",TABLE2_DIR);
        uriMatcher.addURI("com.example.app.provider","table2",TABLE2_ITEM);
    }
    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch (uriMatcher.match(uri)){
            case TABLE_DIR:
                //查询table1所有数据
                break;
            case TABLE_ITEM:
                //查询table1单条数据
                break;
            case TABLE2_DIR:
                //查询table2所有数据
                break;
            case TABLE2_ITEM:
                //查询table2单条数据
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)){
            case TABLE_DIR:
                return "vnd.android.cursor.dir//vnd.com.example.app.provider.table1";
            case TABLE_ITEM:
                //查询table1单条数据
                return "vnd.android.cursor.item//vnd.com.example.app.provider.table1";

            case TABLE2_DIR:
                //查询table2所有数据
                return "vnd.android.cursor.dir//vnd.com.example.app.provider.table2";
            case TABLE2_ITEM:
                //查询table2单条数据
                return "vnd.android.cursor.item//vnd.com.example.app.provider.table2";
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
