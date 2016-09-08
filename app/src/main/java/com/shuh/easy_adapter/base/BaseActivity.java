package com.shuh.easy_adapter.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by pc-135 on 2016/9/8.
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        findViews();
        initViews(savedInstanceState);
    }


    protected abstract void findViews();

    protected abstract void initViews(Bundle savedInstanceState);
}
