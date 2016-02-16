package com.zhangxt4.tabviewpagerindicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;

import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhangxt4 on 2016/2/8.
 */
public class MainActivity extends FragmentActivity {
    //ViewPager,以及它的适配器和数据源
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;
    private  mTabPageIndicator;

    public static String[] TITLES = {"课程", "问答", "求课", "学习", "计划"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_indicator); //这里的资源R一定是对应的，别忘了修改，否则报错
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_indicatorvp);
        mTabPageIndicator = (TabPageIndicator) findViewById(R.id.id_vpindicator);

        //4个Fragment组成数据源
        mFragments = new ArrayList<Fragment>();
        Fragment coFragment = new CourseFragment();
        Fragment qaFragment = new QaFragment();
        Fragment fcFragment = new ForCourseFragment();
        Fragment leFragment = new LearningFragment();
        Fragment plFragment = new PlanFragment();
        mFragments.add(coFragment);
        mFragments.add(qaFragment);
        mFragments.add(fcFragment);
        mFragments.add(leFragment);
        mFragments.add(plFragment);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return TITLES[position];
            }
        };

        mViewPager.setAdapter(mAdapter);
        mTabPageIndicator.setViewPager(mViewPager, 0);
    }

}
