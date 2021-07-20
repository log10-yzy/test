package com.example.appservice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ControllerActivity{
    private static List<Activity> activityList=new ArrayList<>();
    public static void addActivity(Activity activity){
        activityList.add(activity);
    }
    public  static void removeActivity(Activity activity){
        activityList.remove(activity);
    }
    public static void FinnishAll(){
        for(Activity activity:activityList){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }

}
