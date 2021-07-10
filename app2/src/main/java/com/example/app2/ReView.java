package com.example.app2;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Printer;
import android.view.View;

import androidx.annotation.Nullable;

import java.io.PrintStream;

public class ReView extends View {
    public ReView(Context context) {
        super(context);
    }
    public ReView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    private void init(){
        Printer mPrint = new Printer() {
            @Override
            public void println(String x) {

            }
        };
    }

}
