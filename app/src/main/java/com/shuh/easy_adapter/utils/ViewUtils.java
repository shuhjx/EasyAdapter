package com.shuh.easy_adapter.utils;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.view.View;

/**
 * Created by pc-135 on 2016/9/7.
 */
public class ViewUtils {

    public static <V extends View> V findViewById(Activity activity, @IdRes int id){
        if(activity == null)
            throw new IllegalArgumentException("The argument activity can not be null,please check your argument!");

        return (V) activity.findViewById(id);
    }

    public static <V extends View> V findViewById(View view, @IdRes int id){
        if(view == null)
            throw new IllegalArgumentException("The argument view can not be null,please check your argument!");

        return (V) view.findViewById(id);
    }

}
