package com.example.thread;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class myService extends Service {
    private static final String STA="MyService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(STA,"OnCreate"+hashCode());
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(STA,"OnStart"+hashCode());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(STA,"OnStartCommand"+hashCode());
        return super.onStartCommand(intent, flags, startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(STA,"OnBind"+hashCode());
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(STA,"OnUnbind"+hashCode());
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(STA,"OnDestroy"+hashCode());
        super.onDestroy();
    }
}
