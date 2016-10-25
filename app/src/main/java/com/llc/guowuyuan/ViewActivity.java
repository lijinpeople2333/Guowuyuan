package com.llc.guowuyuan;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.llc.guowuyuan.com.llc.guowuyuan.fragment.Fragment_gr;
import com.llc.guowuyuan.com.llc.guowuyuan.fragment.Fragment_li;
import com.llc.guowuyuan.com.llc.guowuyuan.fragment.Fragment_yu;

import java.util.ArrayList;
import java.util.List;


public class ViewActivity extends FragmentActivity {

    private ViewPager vp;
    private List<Fragment> list;
    private String[] str;
    TabLayout tablelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        vp = (ViewPager) findViewById(R.id.vp2);
        tablelayout = (TabLayout) findViewById(R.id.tablelayout);
        init();
        inif();
        initData();
        for (int i = 0; i < str.length; i++) {
            //给tablelayout添加导航条目
            tablelayout.addTab(tablelayout.newTab().setText(str[i]));
        }
    }

    private void inif() {
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablelayout));
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for (int i = 0; i < list.size(); i++) {
                    LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
                    TextView tv = (TextView) ll.getChildAt(i);
                    if (position == i) {
                        tv.setTextColor(Color.RED);
                    } else {
                        tv.setTextColor(Color.BLACK);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tablelayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void init() {
        list = new ArrayList<Fragment>();
        Fragment_gr f1 = new Fragment_gr();
        Fragment_li f2 = new Fragment_li();
        Fragment_yu f3 = new Fragment_yu();
        list.add(f1);
        list.add(f2);
        list.add(f3);
    }

    private void initData() {
        str = new String[]{" ", " ", " "};
    }
}
