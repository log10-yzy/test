package com.example.application1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Printer;
import android.view.View;

import androidx.annotation.Nullable;

class ReView extends View {

    private Paint mprint;
    public ReView(Context context) {
        super(context);
    }

    public ReView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ReView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(){
        mprint=new Paint();
    }
    protected void onMeasure(int with,int height){
        super.onMeasure(with,height);

        int widthMode=MeasureSpec.getMode(with);
        int heightMode=MeasureSpec.getMode(height);

        int widthSize=MeasureSpec.getSize(with);
        int heightSize=MeasureSpec.getSize(height);

        int width = 0;
        int heights=0;
        if(widthMode==MeasureSpec.AT_MOST&& heightMode==MeasureSpec.AT_MOST){
            width=300;
            heights=300;
        }
        else if(widthMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(300,heightSize);
        }
        else if(heightMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSize,300);
        }
        if(heightMode==MeasureSpec.EXACTLY){
            heights=heightSize;
        }
        if(widthMode==MeasureSpec.AT_MOST){
            width=heightSize;
        }
        if(widthMode==MeasureSpec.EXACTLY){
            width=heightSize;
        }
        if(heightMode==MeasureSpec.AT_MOST){
            heights=widthSize;
        }
        setMeasuredDimension(width,heights);
    }
//    protected void onLayDraw(Boolean changed,int left,int right,int top,int bottom){
//        super.onDraw();
//    }


    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

    }
}
