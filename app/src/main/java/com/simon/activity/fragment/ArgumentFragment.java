package com.simon.activity.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simon.activity.R;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 *
 * 传递参数给Fragment的使用的写法（解构）
 */

public class ArgumentFragment extends Fragment {
    private String mArgument;
    public static final String ARGUMENT="argument";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null){
            mArgument=bundle.getString(ARGUMENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    /**
     * 通过这种方式来构建Fragment,避免和Activity耦合
     * @param argument
     * @return
     */
    public static ArgumentFragment newInstance(String argument){
        Bundle bundle=new Bundle();
        bundle.putString(ARGUMENT,argument);
        ArgumentFragment  ArgumentFragment=new ArgumentFragment();
        ArgumentFragment.setArguments(bundle);
        return  ArgumentFragment;
    }



}
