package com.noprom.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.noprom.app.Fragment.TabFragment;

/**
 * Created by noprom on 2015/2/21.
 */
public class TabAdapter extends FragmentPagerAdapter {

    public static String[] titles = new String[]{"课程", "问答", "求课", "学习", "计划"};


    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        TabFragment fragment = new TabFragment(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return titles[position];
    }
}
