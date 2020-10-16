package com.lyc.tablayouttest.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;
import com.lyc.tablayouttest.Fragment.ContactFragment;
import com.lyc.tablayouttest.MyTabLayout;
import com.lyc.tablayouttest.MyViewPager;
import com.lyc.tablayouttest.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyTabLayout tabLayout;
    private MyViewPager viewPager;
    private List<Fragment> list = new ArrayList<>();
    private String[] tabTitles;
    private int[] tabImagesId;
    private ContactFragment contactFragment1 = new ContactFragment();
    private ContactFragment contactFragment2 = new ContactFragment();



    private Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabLayout();
        setTabOnClickListener();

    }

    private void setTabOnClickListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                更换样式
                setTabStyleWithSelect(tab);
//
//                int position = tab.getPosition();
                viewPagerShow(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                setTabStyleWithSelect(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void viewPagerShow(int position) {
        mContent = list.get(position);

    }

    /**
     * @Author: "LYCGGG"
     * @Description: 初始化TabLayout,ViewPager,tab样式等
     * @Param: * @param
     * @return: void
     * @Date: 2020/10/9
     */
    private void initTabLayout() {
        tabLayout = findViewById(R.id.main_tab_layout);
        viewPager = findViewById(R.id.main_view_pager);

        tabTitles = new String[]{getString(R.string.contacts),getString(R.string.favorites)};
        tabImagesId = new int[]{R.drawable.ic_tab_contacts,R.drawable.ic_tab_favorite};
        list.add(contactFragment1);
        list.add(contactFragment2);
//        list.add(fragmentTest1);
//        list.add(fragmentTest2);

        tabLayout.setupWithViewPager(viewPager);
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, list);
        viewPager.setAdapter(myFragmentPagerAdapter);

        //为tabLayout的每个tab设置样式(目前只设置文本)
        for(int i=0;i<tabLayout.getTabCount();i++){
//            设置样式
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(getTabView(i));
//            tabLayout.getTabAt(i).setCustomView(getTabView(i));
            if (i == 0) {
//                TODO:
//                设置为1时两个都选中了,why
//                tabLayout.getTabAt(i).select();
                tab.select();
            }
            setTabStyleWithSelect(tab);

        }

    }

    private void setTabStyleWithSelect(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        TextView textView = view.findViewById(R.id.tabItemText);
//        LogUtil.d(textView.getText().toString() + tab.isSelected());
        if (tab.isSelected()) {
            textView.setTextAppearance(R.style.TabTextSelect);
//            textView.setTextSize(24);
//            textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        } else {
            textView.setTextAppearance(R.style.TabTextUnselected);
//            textView.setTextSize(18);
//            textView.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @NotNull
    private View getTabView(int position) {
        View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.tablayout_item,null);
        ImageView imageView = view.findViewById(R.id.tabItemImage);
        TextView textView = view.findViewById(R.id.tabItemText);
        textView.setText(tabTitles[position]);
        imageView.setImageDrawable(getDrawable(tabImagesId[position]));
        return view;
    }


    /**
     * @Author: "LYCGGG"
     * @Description: 内部类FragmentPagerAdapter，用来将两个在当前界面要展示的Fragment和View Pager绑定
     * @Date: 2020/10/9
     * 根据Android开发文档，此类已经被弃用，建议替换成FragmentStateAdapter
     */
    private static class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> list;

        public MyFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> list) {
            super(fm, behavior);
            this.list = list;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }
}
