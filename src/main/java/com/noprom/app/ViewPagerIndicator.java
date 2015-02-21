package com.noprom.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;

import com.viewpagerindicator.TabPageIndicator;

import java.util.List;


public class ViewPagerIndicator extends FragmentActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private TabPageIndicator mTabPageIndicator;
    private List<Fragment> mViews;
    private TabAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.viewpager_indicator);

        initView();

        initEvents();
    }


    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mTabPageIndicator = (TabPageIndicator) findViewById(R.id.id_indicator);
        mAdapter = new TabAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabPageIndicator.setViewPager(mViewPager,0);
    }

    private void initEvents() {

    }

    @Override
    public void onClick(View v) {

    }
}
