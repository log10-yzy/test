package com.example.lifecycle;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class BlankFragment2 extends Fragment {

    private View textView;
    public BlankFragment2() {
        // Required empty public constructor
    }

    private IFragmentCallBack iFragmentCallBack;
    public void setiFragmentCallBack(IFragmentCallBack CallBack){
        iFragmentCallBack=CallBack;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(textView==null){
            textView = inflater.inflate(R.layout.fragment_blank2, container, false);
        }
        Button button=textView.findViewById(R.id.btn_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iFragmentCallBack.sentMsgToActivity("hello ,i'am come from BlankFragment2");
            }
        });
        Button button1=textView.findViewById(R.id.btn_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg= iFragmentCallBack.getMsgFromActivity("null");
                Toast.makeText(BlankFragment2.this.getContext(),msg,Toast.LENGTH_LONG).show();
            }
        });
        return textView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}