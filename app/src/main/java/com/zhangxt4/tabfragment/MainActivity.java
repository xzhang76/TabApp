package com.zhangxt4.tabfragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.zhangxt4.tabviewpagerindicator.R;

/**
 * Created by zhangxt4 on 2016/2/4.
 */
public class MainActivity extends Activity implements View.OnClickListener{
    //四个Fragment
    private Fragment wxFragment;
    private Fragment frFragment;
    private Fragment adFragment;
    private Fragment seFragment;

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
        setContentView(R.layout.activity_main_fragment); //这里的资源R一定是对应的，别忘了修改，否则报错
        initView();
        initEvent();
    }
    private void initView() {
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
        //显示地show一下微信fragment
        setSelect(WEIXINTAB);
    }

    private void initEvent() {
        //四个LinearLayout点击事件
        mTabWeixin.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //重置所有的图片为暗色
        resetImages();
        switch (v.getId()){
            case R.id.id_tab_weixin:
                setSelect(WEIXINTAB);
                break;
            case R.id.id_tab_friend:
                setSelect(FRIENDTAB);
                break;
            case R.id.id_tab_address:
                setSelect(ADDRESSTAB);
                break;
            case R.id.id_tab_settings:
                setSelect(SETTINGTAB);
                break;
        }
    }

    private void setSelect(int tab) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        //隐藏所有的Fragment
        hiddenFragment(transaction);

        switch (tab){
            case WEIXINTAB:
                if (wxFragment == null){
                    wxFragment = new WeixinFragment();
                    transaction.add(R.id.id_framelayout, wxFragment);
                }else {
                    transaction.show(wxFragment);
                }
                mWeixinImgBt.setImageResource(R.mipmap.tab_weixin_pressed);
                break;
            case FRIENDTAB:
                if (frFragment == null){
                    frFragment = new FriendFragment();
                    transaction.add(R.id.id_framelayout, frFragment);
                }else {
                    transaction.show(frFragment);
                }
                mFriendImgBt.setImageResource(R.mipmap.tab_find_frd_pressed);
                break;
            case ADDRESSTAB:
                if (adFragment == null){
                    adFragment = new AddressFragment();
                    transaction.add(R.id.id_framelayout, adFragment);
                }else {
                    transaction.show(adFragment);
                }
                mAddressImgBt.setImageResource(R.mipmap.tab_address_pressed);
                break;
            case SETTINGTAB:
                if (seFragment == null){
                    seFragment = new SettingsFragment();
                    transaction.add(R.id.id_framelayout, seFragment);
                }else {
                    transaction.show(seFragment);
                }
                mSettingImgBt.setImageResource(R.mipmap.tab_settings_pressed);
                break;
        }
        transaction.commit();
    }

    //隐藏所有的Fragment
    private void hiddenFragment(FragmentTransaction transaction) {
        if (wxFragment != null){
            transaction.hide(wxFragment);
        }
        if (frFragment != null){
            transaction.hide(frFragment);
        }
        if (adFragment != null){
            transaction.hide(adFragment);
        }
        if (seFragment != null){
            transaction.hide(seFragment);
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
