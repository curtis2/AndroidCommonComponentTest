package com.simon.activity.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.simon.activity.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragmentActivity extends AppCompatActivity implements View.OnClickListener {
    public  static  final String TAG="fragment";

    @BindView(R.id.a) ImageView a;
    @BindView(R.id.b) ImageView b;
    @BindView(R.id.c) ImageView c;
    @BindView(R.id.d) ImageView d;

    ContentFragment mContentFragment;
    FriendFragment mFriendFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frament_dynamic);
        ButterKnife.bind(this);

        a.setOnClickListener(this);
        b.setOnClickListener(this);

       setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm=getFragmentManager();
        //开始fragment的事物
        FragmentTransaction fragmentTransaction=fm.beginTransaction();
        mContentFragment=new ContentFragment();
        fragmentTransaction.replace(R.id.content_fragment,mContentFragment);
        fragmentTransaction.commit();
/*
   执行顺序
        08-25 16:44:55.342 577-577/com.simon.activity I/fragment: ContentFragment-onCreate
        08-25 16:44:55.342 577-577/com.simon.activity I/fragment: ContentFragment-onCreateView
        08-25 16:44:55.344 577-577/com.simon.activity I/fragment: ContentFragment-onActivityCreated*/

    }


    @Override
    public void onClick(View v) {
        FragmentManager fm=getFragmentManager();
        //开始fragment的事物
        FragmentTransaction fragmentTransaction=fm.beginTransaction();
        switch (v.getId()){
            case R.id.a:
                if(mContentFragment==null){
                    mContentFragment=new ContentFragment();
                }
                fragmentTransaction.replace(R.id.content_fragment,mContentFragment);
                break;
            case R.id.b:
                if(mFriendFragment==null){
                    Log.i(TAG,"MainFragmentActivity-new FriendFragment");
                    mFriendFragment=new FriendFragment();
                }
//                Log.i(TAG,"MainFragmentActivity- replace");
//                fragmentTransaction.replace(R.id.content_fragment,mFriendFragment);
         /*
             执行顺序，
              1.直接replace的时候先执行之前的fragment的onDestroyView等方法
              2.需要在fragmentTransaction执行commit方法后，fragment的生命周期方法才进行
                08-25 20:33:24.929 11877-11877/com.simon.activity I/fragment: MainFragmentActivity-new FriendFragment
                08-25 20:33:24.932 11877-11877/com.simon.activity I/fragment: MainFragmentActivity- replace
                08-25 20:33:24.932 11877-11877/com.simon.activity I/fragment: MainFragmentActivity- commit
                08-25 20:33:24.932 11877-11877/com.simon.activity I/fragment: ContentFragment-onPause
                08-25 20:33:24.932 11877-11877/com.simon.activity I/fragment: ContentFragment-onStop
                08-25 20:33:24.932 11877-11877/com.simon.activity I/fragment: ContentFragment-onDestroyView
                08-25 20:33:24.932 11877-11877/com.simon.activity I/fragment: ContentFragment-onDestroy
                08-25 20:33:24.932 11877-11877/com.simon.activity I/fragment: ContentFragment-onDetach
                08-25 20:33:24.933 11877-11877/com.simon.activity I/fragment: FriendFragment-onCreate
                08-25 20:33:24.933 11877-11877/com.simon.activity I/fragment: FriendFragment-onCreateView
                08-25 20:33:24.935 11877-11877/com.simon.activity I/fragment: FriendFragment-onActivityCreated
                08-25 20:33:24.935 11877-11877/com.simon.activity I/fragment: FriendFragment-onStart
                08-25 20:33:24.935 11877-11877/com.simon.activity I/fragment: FriendFragment-onResume
         */
//                Log.i(TAG,"MainFragmentActivity- remove add");
//                fragmentTransaction.remove(mContentFragment);
//                fragmentTransaction.add(R.id.content_fragment,mFriendFragment);
 /*
                remove和add方法后的执行顺序
                执行顺序：
                08-25 20:32:28.596 11163-11163/com.simon.activity I/fragment: MainFragmentActivity-new FriendFragment
                08-25 20:32:28.600 11163-11163/com.simon.activity I/fragment: MainFragmentActivity- remove add
                08-25 20:32:28.600 11163-11163/com.simon.activity I/fragment: MainFragmentActivity- commit
                08-25 20:32:28.601 11163-11163/com.simon.activity I/fragment: ContentFragment-onPause
                08-25 20:32:28.601 11163-11163/com.simon.activity I/fragment: ContentFragment-onStop
                08-25 20:32:28.601 11163-11163/com.simon.activity I/fragment: ContentFragment-onDestroyView
                08-25 20:32:28.601 11163-11163/com.simon.activity I/fragment: ContentFragment-onDestroy
                08-25 20:32:28.601 11163-11163/com.simon.activity I/fragment: ContentFragment-onDetach
                08-25 20:32:28.601 11163-11163/com.simon.activity I/fragment: FriendFragment-onCreate
                08-25 20:32:28.602 11163-11163/com.simon.activity I/fragment: FriendFragment-onCreateView
                08-25 20:32:28.605 11163-11163/com.simon.activity I/fragment: FriendFragment-onActivityCreated
                08-25 20:32:28.605 11163-11163/com.simon.activity I/fragment: FriendFragment-onStart
                08-25 20:32:28.605 11163-11163/com.simon.activity I/fragment: FriendFragment-onResume
                */
                Log.i(TAG,"MainFragmentActivity- hide show");
                fragmentTransaction.hide(mContentFragment);
                fragmentTransaction.add(R.id.content_fragment,mFriendFragment);
              /*
                执行顺序：
                1.hide方法执行时，fragment生命生命周期都没有执行

                08-25 20:37:12.040 14418-14418/com.simon.activity I/fragment: MainFragmentActivity-new FriendFragment
                08-25 20:37:12.044 14418-14418/com.simon.activity I/fragment: MainFragmentActivity- hide show
                08-25 20:37:12.044 14418-14418/com.simon.activity I/fragment: MainFragmentActivity- commit
                08-25 20:37:12.045 14418-14418/com.simon.activity I/fragment: FriendFragment-onCreate
                08-25 20:37:12.045 14418-14418/com.simon.activity I/fragment: FriendFragment-onCreateView
                08-25 20:37:12.048 14418-14418/com.simon.activity I/fragment: FriendFragment-onActivityCreated
                08-25 20:37:12.048 14418-14418/com.simon.activity I/fragment: FriendFragment-onStart
                08-25 20:37:12.048 14418-14418/com.simon.activity I/fragment: FriendFragment-onResume
                */
           break;
        }

        //提交事物
        Log.i(TAG,"MainFragmentActivity- commit");
        fragmentTransaction.commit();
    }
}
