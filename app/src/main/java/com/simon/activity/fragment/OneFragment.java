package com.simon.activity.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.simon.activity.R;

import static com.simon.activity.fragment.DialogFragment.RESPONSE_EVALUATE;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class OneFragment extends Fragment {
    public  static  final String TAG="fragment";
    public static final int REQUEST_EVALUATE = 0X110;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG,"OneFragment-onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"OneFragment-onCreate");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Log.i(TAG,"OneFragment-onCreateView");
        View view=inflater.inflate(R.layout.fragment_one, container, false);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showEditDialog();
        /*      FragmentManager fragmentManager=getFragmentManager();
                TwoFragment twoFragment=new TwoFragment();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_fragment,twoFragment,"TWO");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/
            }
        });
        return view;
    }



    //接收返回回来的数据
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_EVALUATE)
        {
            String evaluate = data
                    .getStringExtra(RESPONSE_EVALUATE);
            Toast.makeText(getActivity(), evaluate, Toast.LENGTH_SHORT).show();
          /*  Intent intent = new Intent();
            intent.putExtra(RESPONSE, evaluate);
            getActivity().setResult(Activity.REQUEST_OK, intent);*/
        }

    }

    public void showEditDialog()
    {
        DialogFragment editNameDialog = new DialogFragment();
        editNameDialog.setTargetFragment(OneFragment.this,REQUEST_EVALUATE);
        editNameDialog.show(getFragmentManager(), "EditNameDialog");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG,"OneFragment-onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"OneFragment-onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"OneFragment-onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"OneFragment-onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"OneFragment-onStop");
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"OneFragment-onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"OneFragment-onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,"OneFragment-onDetach");
    }

}

