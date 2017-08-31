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

public class ContentFragment extends Fragment {
    public  static  final String TAG="fragment";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG,"ContentFragment-onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"ContentFragment-onCreate");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Log.i(TAG,"ContentFragment-onCreateView");
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG,"ContentFragment-onActivityCreated");
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"ContentFragment-onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"ContentFragment-onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"ContentFragment-onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"ContentFragment-onStop");
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"ContentFragment-onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"ContentFragment-onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,"ContentFragment-onDetach");
    }

}

