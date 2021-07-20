package bean;

import android.content.Context;
import android.widget.Toast;
public class UtilToast {
    public static void Util(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
