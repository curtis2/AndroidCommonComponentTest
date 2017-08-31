package com.simon.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {
    public static final String TAG="tag";
    private MyService.MyBinder myBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyService.MyBinder) service;
            Log.i(TAG, "onServiceConnected"+myBinder);
            myBinder.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i(TAG,"SecondActivity-onCreate");
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"SecondActivity-onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"SecondActivity-onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"SecondActivity-onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"SecondActivity-onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"SecondActivity-onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"SecondActivity-onDestroy");
    }
}
