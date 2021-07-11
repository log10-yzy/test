package com.example.lifecycle;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment_two extends Fragment {
    private Button button;
    private TextView textView;
    public static final String TAG=fragment_two.class.getSimpleName();//得到类的简单名
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach");
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
    }
/*
fragment 组件的自我控制 静态
 */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View view=inflater.inflate(R.layout.fragmenttwo,container,false);
        textView= view.findViewById(R.id.frag2txt);
        button=view.findViewById(R.id.frag2button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("fragment 的自我跟新");
            }
        });
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreate");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreate");
        super.onViewCreated(view, savedInstanceState);
    }
//    @Override
//    public void onStart() {
//        Log.i(TAG, "onStart");
//        super.onStart();
//    }
//
//    @Override
//    public void onResume() {
//        Log.i(TAG, "onResume");
//        super.onResume();
//    }
//    //之前是Activity先调用  之后是fragment先调用
//    @Override
//    public void onPause() {
//        Log.i(TAG, "onPause");
//        super.onPause();
//    }
//
//    @Override
//    public void onStop() {
//        Log.i(TAG, "onStop");
//        super.onStop();
//    }
//
//    @Override
//    public void onDestroyView() {
//        Log.i(TAG, "onDestroyView");
//        super.onDestroyView();
//    }
//
//    @Override
//    public void onDestroy() {
//        Log.i(TAG, "onDestroy");
//        super.onDestroy();
//    }
//
//    @Override
//    public void onDetach() {
//        Log.i(TAG, "onDetach");
//        super.onDetach();
//    }
}
