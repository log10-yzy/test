package com.example.appservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class RemoteService extends Service {
    private Mybinder mybinder;
    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        if(mybinder==null){
            mybinder=new Mybinder();
        }
        return mybinder;
    }

}