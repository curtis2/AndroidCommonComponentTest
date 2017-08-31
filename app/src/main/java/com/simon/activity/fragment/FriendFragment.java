package com.simon.activity.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simon.activity.R;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class FriendFragment extends Fragment {
    public  static  final String TAG="fragment";
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG,"FriendFragment-onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"FriendFragment-onCreate");
    }

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Log.i(TAG,"FriendFragment-onCreateView");
        return inflater.inflate(R.layout.fragment_friend, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG,"FriendFragment-onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"FriendFragment-onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"FriendFragment-onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"FriendFragment-onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"FriendFragment-onStop");
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"FriendFragment-onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"FriendFragment-onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,"FriendFragment-onDetach");
    }
}
