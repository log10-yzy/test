package bean;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.content.ContextCompat;

import com.example.imitationalipay.R;

public class ClearEditText extends androidx.appcompat.widget.AppCompatEditText {

    private Context context;
    private Paint paint;

    private final static String Tag="EditTextWithDel";
    private Drawable imgA;
    public ClearEditText(Context context) {
        super(context);
        this.context=context;
        init();
    }
//
    public ClearEditText(Context context, AttributeSet attributeSet,int def){
        super(context,attributeSet,def);
        this.context=context;
        init();

    }
    //
    public ClearEditText(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        paint=new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        this.context=context;
        init();

    }
    private void init() {
        imgA=ContextCompat.getDrawable(context, R.drawable.delete);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                setDrawable();
            }
        });
        setDrawable();
    }

    private void setDrawable() {
        if(length()<1){
            setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        }
        else
            setCompoundDrawablesWithIntrinsicBounds(null,null,imgA,null);
    }
    public boolean onTouchEvent(MotionEvent event){
        if(imgA!=null&& event.getAction()==MotionEvent.ACTION_UP){
            int eventX=(int) event.getRawX();
            int eventY=(int) event.getRawY();
//            Log.v(Tag,"eventX"+eventX+";eventY"+eventY);
            Rect rect=new Rect();
            getGlobalVisibleRect(rect);
            rect.left=rect.right-50;

            if(rect.contains(eventX,eventY))
                setText("");
        }
        return super.onTouchEvent(event);
    }

    protected void finalize()throws Throwable{
        super.finalize();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, this.getHeight()-2, this.getWidth()-2, this.getHeight()-2, paint);
    }
}
