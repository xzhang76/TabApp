package com.zhangxt4.tabviewpager;

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

import com.zhangxt4.tabviewpagerindicator.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<View> mViews = new ArrayList<View>();

    //底部的四个tab
    private LinearLayout mTabWeixin;
    private LinearLayout mTabFriend;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    //底部的四个ImageButton,因为要改变ImageButton的image
    private ImageButton mWeixinImgBt;
    private ImageButton mFriendImgBt;
    private ImageButton mAddressImgBt;
    private ImageButton mSettingImgBt;

    //四个当前tab常量
    private static final int WEIXINTAB = 0;
    private static final int FRIENDTAB = 1;
    private static final int ADDRESSTAB = 2;
    private static final int SETTINGTAB = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main); //这里的资源R一定是对应的，别忘了修改，否则报错
        initView();
        initEvent();
    }
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        //tabs
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFriend = (LinearLayout) findViewById(R.id.id_tab_friend);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_settings);
        //imageButtons
        mWeixinImgBt = (ImageButton) findViewById(R.id.id_img_weixin);
        mFriendImgBt = (ImageButton) findViewById(R.id.id_img_friend);
        mAddressImgBt = (ImageButton) findViewById(R.id.id_img_address);
        mSettingImgBt = (ImageButton) findViewById(R.id.id_img_settings);

        //tab views
        LayoutInflater mInflater = LayoutInflater.from(this);
        View weixinView = mInflater.inflate(R.layout.tabweixin, null);
        View friendView = mInflater.inflate(R.layout.tabfriend, null);
        View addressView = mInflater.inflate(R.layout.tabaddress, null);
        View settingView = mInflater.inflate(R.layout.tabsettings, null);
        mViews.add(weixinView);
        mViews.add(friendView);
        mViews.add(addressView);
        mViews.add(settingView);

        //匿名的adapter
        mPagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }
        };

        mViewPager.setAdapter(mPagerAdapter);

    }

    private void initEvent() {
        mTabWeixin.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
        //为ViewPager添加滑动变化的监听事件
        //为了滑动不同的tab时，下面的ImageButton也对应变化
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = mViewPager.getCurrentItem();
                resetImages();
                switch (currentItem){
                    case WEIXINTAB:
                        mWeixinImgBt.setImageResource(R.mipmap.tab_weixin_pressed);
                        break;
                    case FRIENDTAB:
                        mFriendImgBt.setImageResource(R.mipmap.tab_find_frd_pressed);
                        break;
                    case ADDRESSTAB:
                        mAddressImgBt.setImageResource(R.mipmap.tab_address_pressed);
                        break;
                    case SETTINGTAB:
                        mSettingImgBt.setImageResource(R.mipmap.tab_settings_pressed);
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
        //首先重置所有的图片为暗色
        resetImages();
        switch (v.getId()){
            case R.id.id_tab_weixin:
                mViewPager.setCurrentItem(0);
                mWeixinImgBt.setImageResource(R.mipmap.tab_weixin_pressed);
                break;
            case R.id.id_tab_friend:
                mViewPager.setCurrentItem(1);
                mFriendImgBt.setImageResource(R.mipmap.tab_find_frd_pressed);
                break;
            case R.id.id_tab_address:
                mViewPager.setCurrentItem(2);
                mAddressImgBt.setImageResource(R.mipmap.tab_address_pressed);
                break;
            case R.id.id_tab_settings:
                mViewPager.setCurrentItem(3);
                mSettingImgBt.setImageResource(R.mipmap.tab_settings_pressed);
                break;
        }
    }

    //设置所有的图片为暗色
    private void resetImages() {
        mWeixinImgBt.setImageResource(R.mipmap.tab_weixin_normal);
        mFriendImgBt.setImageResource(R.mipmap.tab_find_frd_normal);
        mAddressImgBt.setImageResource(R.mipmap.tab_address_normal);
        mSettingImgBt.setImageResource(R.mipmap.tab_settings_normal);

    }
}
