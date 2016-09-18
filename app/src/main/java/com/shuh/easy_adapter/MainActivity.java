package com.shuh.easy_adapter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

import com.shuh.easy_adapter.adapter.EasyAdapter;
import com.shuh.easy_adapter.adapter.EasyHolder;
import com.shuh.easy_adapter.base.BaseActivity;
import com.shuh.easy_adapter.fragment.Demo1Fragment;
import com.shuh.easy_adapter.fragment.Demo2Fragment;
import com.shuh.easy_adapter.fragment.RxAndroidFragment;
import com.shuh.easy_adapter.utils.ViewUtils;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    String[] titles = {"11", "22", "33"};

    @Override
    protected void findViews() {
        setContentView(R.layout.activity_main);
        tabLayout = ViewUtils.findViewById(this, R.id.tablelayout);
        toolbar = ViewUtils.findViewById(this, R.id.toolbar);
        viewPager = ViewUtils.findViewById(this, R.id.viewpager);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        tabLayout.setTabTextColors(Color.WHITE, Color.GRAY);
        tabLayout.addTab(tabLayout.newTab(), true);
        tabLayout.addTab(tabLayout.newTab(), false);
        tabLayout.addTab(tabLayout.newTab(), false);

        fragments.add(new RxAndroidFragment());
        fragments.add(new Demo1Fragment());
        fragments.add(new Demo2Fragment());
        viewPager.setAdapter(adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }
        });

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);
    }


}
