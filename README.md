## TabApp 多种实现方式

### 1.ViewPager实现Tab
    对应包tabviewpager
    缺点：每一页只是一个View,其中如果有丰富的控件就不好操作了
* 布局使用ViewPager
* 数据源使用View的List集合
* 适配器使用PagerAdapter,重写几个接口
* ViewPager需要设置滑动监听 <br>
mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { }; <br>

### 2.Fragment实现Tab
    对应包tabfragment
    优缺点：每页是一个Fragment，但不能左右滑动
* 布局使用FrameLayout
* 数据源是Fragment的List集合
* 点击底部的ImageButton可以实现不同的Fragment切换，需要通过FragmentManager和FragmentTransaction
<br>

### 3.FragmentPagerAdapter+ViewPager实现Tab
    对应包tabfragmentpager
    优缺点：每页都是fragment，可以点击切换，可以滑动切换
* 布局是ViewPager
* 数据源是Fragment的List集合
* 适配器是FragmentPagerAdapter,重写接口
* ViewPager需要设置页面切换监听 <br>
mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { }; <br>
<br>

### 4.ViewPagerIndicator+ViewPager实现Tab
    对应包tabviewpagerindicator
    优缺点：还是原来的ViewPager+FragmentPagerAdapter，只是多加了一个ViewPagerIndicator设置标题
* 布局为ViewPagerIndicator+ViewPager
* 数据源是Fragment的List集合
* 适配器是FragmentPagerAdapter,重写接口
* ViewPager不需要设置监听
* 需要为ViewPagerIndicator绑定ViewPager <br>
mViewPager.setAdapter(mAdapter); <br>
mTabPageIndicator.setViewPager(mViewPager, 0);

    [我的笔记](http://www.imooc.com/note/264?ower=all&sort=last)
    http://www.imooc.com/note/264?ower=all&sort=last
