package com.example.wechat.Uitls;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 铖哥 on 2017/4/23.
 */

public class ActivityHelper {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity : activities){
            activity.finish();
        }
        activities.clear();
    }

    public static Activity getTopActivity(){
        return activities.get(activities.size()-1);
    }



}
