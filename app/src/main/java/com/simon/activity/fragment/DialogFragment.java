package com.simon.activity.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class DialogFragment extends android.app.DialogFragment {

    public  static  final String TAG="fragment";

    private String[] mEvaluteVals = new String[] { "GOOD", "BAD", "NORMAL" };
    public static final String RESPONSE_EVALUATE = "response_evaluate";


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG,"DialogFragment-onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"DialogFragment-onCreate");
    }


/*    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.fragment_dialog_layout, container);
        return view;
    }*/
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Evaluate :").setItems(mEvaluteVals,
                new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        setResult(which);
                    }
                });
        return builder.create();
    }

    // 设置返回数据
    protected void setResult(int which)
    {
        // 判断是否设置了targetFragment
        if (getTargetFragment() == null)
            return;

        Intent intent = new Intent();
        intent.putExtra(RESPONSE_EVALUATE, mEvaluteVals[which]);
        getTargetFragment().onActivityResult(OneFragment.REQUEST_EVALUATE,Activity.RESULT_OK, intent);

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG,"DialogFragment-onActivityCreated");
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"DialogFragment-onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"DialogFragment-onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"DialogFragment-onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"DialogFragment-onStop");
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"DialogFragment-onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"DialogFragment-onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,"DialogFragment-onDetach");
    }
}
