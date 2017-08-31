package com.simon.activity.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.simon.activity.R;

import butterknife.ButterKnife;


/**
 * 1.考虑到Fragment的复用性，fragment应该和Activity解构
 * 2.fragment中不应该再操作其他的Fragment了。fragment应该作为最基础的组件
 */

public class MainTaskFragmentActivity extends AppCompatActivity  {
    public  static  final String TAG="fragment";
    public static final String RESPONSE = "response";
    public static final int REQUEST_EVALUATE = 0X110;
    OneFragment mContentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frament_task);
        ButterKnife.bind(this);

        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm=getFragmentManager();
        //开始fragment的事物
        FragmentTransaction fragmentTransaction=fm.beginTransaction();
        mContentFragment=new OneFragment();
        fragmentTransaction.replace(R.id.content_fragment,mContentFragment,"ONE");
        fragmentTransaction.commit();
    }



}
