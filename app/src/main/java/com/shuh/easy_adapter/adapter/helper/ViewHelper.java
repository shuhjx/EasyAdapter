package com.shuh.easy_adapter.adapter.helper;

import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.view.View;

import com.shuh.easy_adapter.adapter.EasyHolder;

/**
 * Created by pc-135 on 2016/9/7.
 */
public interface ViewHelper {

    interface AbsListView<E extends EasyHolder> {

        E setText(@IdRes int id, String value);
        E setText(@IdRes int id, @StringRes int value);
        E setTextColor(@IdRes int id, int color);
        E setTextColorRes(@IdRes int id, @ColorRes int color);
        E setOnClickListener(@IdRes int id, View.OnClickListener listener);
        E setBackgroundColor(@IdRes int id, int color);
        E setBackgroundResource(@IdRes int id, int color);
        E setVisible(@IdRes int id, int visibility);
        E setTag(@IdRes int id, Object tag);
        E setTag(@IdRes int id, int key, Object tag);

    }
}
