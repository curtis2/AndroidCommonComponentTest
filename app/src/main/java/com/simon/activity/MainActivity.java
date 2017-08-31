package com.simon.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "tag";
//  private MyService.MyBinder myBinder;
    private MyAIDLService myAIDLService;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myAIDLService = MyAIDLService.Stub.asInterface(service);
            try {
                int result = myAIDLService.plus(1, 2);
                String toUpperCase = myAIDLService.toUpperCase("hello word");
                Log.i(TAG, "result="+result);
                Log.i(TAG, "toUpperCase="+toUpperCase);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "MainActivity-onCreate");
        findViewById(R.id.button_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RemoteService.class);
                startService(intent);
            }
        });

        findViewById(R.id.button_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RemoteService.class);
                stopService(intent);
            }
        });

        findViewById(R.id.bind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RemoteService.class);
                bindService(intent, connection, BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.unbind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(connection);
            }
        });

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FrontService.class);
                startService(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"MainActivity-onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"MainActivity-onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"MainActivity-onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"MainActivity-onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"MainActivity-onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"MainActivity-onDestroy");
    }

}
