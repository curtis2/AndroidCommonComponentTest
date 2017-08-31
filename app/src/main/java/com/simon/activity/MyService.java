package com.simon.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */
public class MyService extends Service {
    public  static  final String TAG="MyService";
    private  MyBinder binder=new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBind");
        return binder;
    }

    public class MyBinder extends Binder{
        public void startDownload(){
            Log.i(TAG,"startDownload");
            Log.i(TAG,"Thread-name"+Thread.currentThread().getName());
        }
    }

}
