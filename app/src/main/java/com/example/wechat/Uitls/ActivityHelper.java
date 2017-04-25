package com.example.wechat.Uitls;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 铖哥 on 2017/4/23.
 */

public class ActivityHelper {

    public static List<Activity> activities = new ArrayList<>();

    /**
     * @param activity the activity that you want to add to backStack
     */
    public static void addActivity(Activity activity){
        activities.add(activity);
    }


    /**
     * @param activity the activity that you want to remove from backStack
     */
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }


    /**
     * clear the stack
     */
    public static void finishAll(){
        for (Activity activity : activities){
            activity.finish();
        }
        activities.clear();
    }


    /**
     * return activity which is at the top of the stack
     * @return
     */
    public static Activity getTopActivity(){
        return activities.get(activities.size()-1);
    }



}
