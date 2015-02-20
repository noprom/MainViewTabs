package com.noprom.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener {

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    private List<View> mViews = new ArrayList<View>();

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFriend;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mWeixinImg;
    private ImageButton mFriendImg;
    private ImageButton mAddressImg;
    private ImageButton mSettingImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();

        initEvents();
    }


    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        // Tabs
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFriend = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_settings);

        // ImageButton
        mWeixinImg = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mFriendImg = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mAddressImg = (ImageButton) findViewById(R.id.id_tab_address_img);
        mSettingImg = (ImageButton) findViewById(R.id.id_tab_settings_img);

        LayoutInflater mInflater = LayoutInflater.from(this);
        View tab01 = mInflater.inflate(R.layout.tab01, null);
        View tab02 = mInflater.inflate(R.layout.tab02, null);
        View tab03 = mInflater.inflate(R.layout.tab03, null);
        View tab04 = mInflater.inflate(R.layout.tab04, null);
        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);

        mAdapter = new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };

        mViewPager.setAdapter(mAdapter);
    }

    private void initEvents() {
        mTabWeixin.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = mViewPager.getCurrentItem();
                resetImg();
                switch (currentItem) {
                    case 0:
                        mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        mFriendImg.setImageResource(R.drawable.tab_find_frd_pressed);

                        break;
                    case 2:
                        mAddressImg.setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        mSettingImg.setImageResource(R.drawable.tab_settings_pressed);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId()) {
            case R.id.id_tab_weixin:
                mViewPager.setCurrentItem(0);
                mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case R.id.id_tab_frd:
                mViewPager.setCurrentItem(1);
                mFriendImg.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case R.id.id_tab_address:
                mViewPager.setCurrentItem(2);
                mAddressImg.setImageResource(R.drawable.tab_address_pressed);
                break;
            case R.id.id_tab_settings:
                mViewPager.setCurrentItem(3);
                mSettingImg.setImageResource(R.drawable.tab_settings_pressed);
                break;
        }
    }

    private void resetImg() {
        mWeixinImg.setImageResource(R.drawable.tab_weixin_normal);
        mFriendImg.setImageResource(R.drawable.tab_find_frd_normal);
        mAddressImg.setImageResource(R.drawable.tab_address_normal);
        mSettingImg.setImageResource(R.drawable.tab_settings_normal);
    }
}
