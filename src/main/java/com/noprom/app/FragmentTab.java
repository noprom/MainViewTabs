package com.noprom.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.noprom.app.Fragment.AddressFragment;
import com.noprom.app.Fragment.FriendFragment;
import com.noprom.app.Fragment.SettingFragment;
import com.noprom.app.Fragment.WeixinFragment;


public class FragmentTab extends FragmentActivity implements View.OnClickListener {


    private LinearLayout mTabWeixin;
    private LinearLayout mTabFriend;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mWeixinImg;
    private ImageButton mFriendImg;
    private ImageButton mAddressImg;
    private ImageButton mSettingImg;

    // Fragment
    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_tab);

        initView();

        initEvents();
        setSelect(0);
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

    private void setSelect(int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);

        // 1.将图片设置为亮色
        // 2.切换内容区域
        switch (i) {
            case 0:
                mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
                if (mTab01 == null) {
                    mTab01 = new WeixinFragment();
                    fragmentTransaction.add(R.id.id_content,mTab01);
                } else {
                    fragmentTransaction.show(mTab01);
//                    if(mTab02!=null) fragmentTransaction.remove(mTab02);
//                    if(mTab03!=null) fragmentTransaction.remove(mTab03);
//                    if(mTab04!=null) fragmentTransaction.remove(mTab04);
                }
                break;
            case 1:
                mFriendImg.setImageResource(R.drawable.tab_find_frd_pressed);
                if (mTab02 == null) {
                    mTab02 = new FriendFragment();
                    fragmentTransaction.add(R.id.id_content,mTab02);
                } else {
                    fragmentTransaction.show(mTab02);
//                    if(mTab01!=null) fragmentTransaction.remove(mTab01);
//                    if(mTab03!=null) fragmentTransaction.remove(mTab03);
//                    if(mTab04!=null) fragmentTransaction.remove(mTab04);
                }
                break;
            case 2:
                mAddressImg.setImageResource(R.drawable.tab_address_pressed);
                if (mTab03 == null) {
                    mTab03 = new AddressFragment();
                    fragmentTransaction.add(R.id.id_content,mTab03);
                } else {
                    fragmentTransaction.show(mTab03);
//                    if(mTab01!=null) fragmentTransaction.remove(mTab01);
//                    if(mTab02!=null) fragmentTransaction.remove(mTab02);
//                    if(mTab04!=null) fragmentTransaction.remove(mTab04);
                }
                break;
            case 3:
                mSettingImg.setImageResource(R.drawable.tab_settings_pressed);
                if (mTab04 == null) {
                    mTab04 = new SettingFragment();
                    fragmentTransaction.add(R.id.id_content,mTab04);
                } else {
                    fragmentTransaction.show(mTab04);
//                    if(mTab01!=null) fragmentTransaction.remove(mTab01);
//                    if(mTab02!=null) fragmentTransaction.remove(mTab02);
//                    if(mTab03!=null) fragmentTransaction.remove(mTab03);
                }
                break;
        }

        // 提交事务
        fragmentTransaction.commit();
    }

    /**
     * 隐藏Fragment
     *
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (mTab01 != null) {
            transaction.hide(mTab01);
        } else if (mTab02 != null) {
            transaction.hide(mTab02);
        } else if (mTab03 != null) {
            transaction.hide(mTab03);
        } else if (mTab04 != null) {
            transaction.hide(mTab04);
        }

    }

    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId()) {
            case R.id.id_tab_weixin:
                setSelect(0);
                break;
            case R.id.id_tab_frd:
                setSelect(1);
                break;
            case R.id.id_tab_address:
                setSelect(2);
                break;
            case R.id.id_tab_settings:
                setSelect(3);
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
