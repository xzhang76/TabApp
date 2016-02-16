package com.zhangxt4.tabfragmentpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import com.zhangxt4.tabviewpagerindicator.R;


/**
 * Created by zhangxt4 on 2016/2/8.
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener {
    //ViewPager,以及它的适配器和数据源
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;
//    //四个Fragment
//    private Fragment wxFragment;
//    private Fragment frFragment;
//    private Fragment adFragment;
//    private Fragment seFragment;

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
        setContentView(R.layout.activity_main_fragmentpager); //这里的资源R一定是对应的，别忘了修改，否则报错
        initView();
        initEvent();
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
                switch (currentItem) {
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

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_fragmentpager);
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
        //4个Fragment组成数据源
        mFragments = new ArrayList<Fragment>();
        Fragment wxFragment = new WeixinFragment();
        Fragment frFragment = new FriendFragment();
        Fragment adFragment = new AddressFragment();
        Fragment seFragment = new SettingsFragment();
        mFragments.add(wxFragment);
        mFragments.add(frFragment);
        mFragments.add(adFragment);
        mFragments.add(seFragment);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };

        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        //首先重置所有的图片为暗色
        resetImages();
        switch (v.getId()){
            case R.id.id_tab_weixin:
                mViewPager.setCurrentItem(WEIXINTAB);
                mWeixinImgBt.setImageResource(R.mipmap.tab_weixin_pressed);
                break;
            case R.id.id_tab_friend:
                mViewPager.setCurrentItem(FRIENDTAB);
                mFriendImgBt.setImageResource(R.mipmap.tab_find_frd_pressed);
                break;
            case R.id.id_tab_address:
                mViewPager.setCurrentItem(ADDRESSTAB);
                mAddressImgBt.setImageResource(R.mipmap.tab_address_pressed);
                break;
            case R.id.id_tab_settings:
                mViewPager.setCurrentItem(SETTINGTAB);
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
