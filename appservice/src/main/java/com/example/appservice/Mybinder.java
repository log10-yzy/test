package com.example.appservice;

import android.os.RemoteException;
import android.util.Log;

public class Mybinder extends MyService.Stub{
    @Override
    public String getName() throws RemoteException {

        Log.v(Mybinder.class.getSimpleName(),"洛洛历险记");
        return "洛洛历险记";
    }

    @Override
    public String getId() throws RemoteException {
        Log.v(Mybinder.class.getSimpleName(),"编号为00001");
        return "00001";
    }

    @Override
    public int getNumbeer() throws RemoteException {
        Log.v(Mybinder.class.getSimpleName(),"数量为10");
        return 10;
    }
}
