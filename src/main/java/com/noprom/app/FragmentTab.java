package com.noprom.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class FragmentTab extends Activity implements View.OnClickListener {


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
        setContentView(R.layout.fragment_tab);

        initView();

        initEvents();
    }


    private void initView() {
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


    }

    private void initEvents() {
        mTabWeixin.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId()) {
            case R.id.id_tab_weixin:
                mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case R.id.id_tab_frd:
                mFriendImg.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case R.id.id_tab_address:
                mAddressImg.setImageResource(R.drawable.tab_address_pressed);
                break;
            case R.id.id_tab_settings:
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
