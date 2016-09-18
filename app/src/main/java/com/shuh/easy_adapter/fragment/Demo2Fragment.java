package com.shuh.easy_adapter.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shuh.easy_adapter.R;
import com.shuh.easy_adapter.base.BaseFragment;

/**
 * Created by Administrator on 2016/9/10 0010.
 */
public class Demo2Fragment extends BaseFragment {
    @Override
    protected View findViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.demo2_fragment, null);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }
}
