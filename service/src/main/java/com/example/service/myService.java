package com.example.service;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.thread.R;

public class myService extends Service {
    private static final String STA="MyService";

    @SuppressLint("WrongConstant")
    @Override
    //服务创建
    public void onCreate() {
        super.onCreate();
        Log.d(STA,"OnCreate"+hashCode());
        //前台服务
        String CHANNEL_ID = "com.example.service";
        String CHANNEL_NAME = "TEST";
        NotificationChannel notificationChannel = null;
        NotificationCompat.Builder builder = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder = new NotificationCompat.Builder(this, CHANNEL_ID).
                setContentTitle(getResources().getString(R.string.app_name)).
                setContentText(getResources().getString(R.string.content)).
                setWhen(System.currentTimeMillis()).
                setSmallIcon(R.mipmap.ic_launcher).
                setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)).
                setContentIntent(pendingIntent).setDefaults(NotificationCompat.FLAG_ONGOING_EVENT)
                .setPriority(Notification.PRIORITY_MAX);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//SDK版本>=21才能设置悬挂式通知栏
            builder.setCategory(String.valueOf(Notification.FLAG_ONGOING_EVENT))
                    .setVisibility(Notification.VISIBILITY_PUBLIC)
                    .setColor(getResources().getColor(R.color.white));
            Intent intent2 = new Intent();
            PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent2, 0);
            builder.setFullScreenIntent(pi, true);
        }
        Notification notification = builder.build();
        startForeground(1, notification);
    }

//    @Override
//    public void onStart(Intent intent, int startId) {
//        super.onStart(intent, startId);
//        Log.d(STA,"OnStart"+hashCode());
//    }

    @Override
    //服务启动
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
