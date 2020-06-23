package com.hanchao.summary.drawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.blankj.utilcode.util.BarUtils;
import com.hanchao.summary.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SlidingRightActivity extends AppCompatActivity {

    @BindView(R.id.content_view)
    FrameLayout contentFrameLayout;
    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.card_view)
    CardView mCard;

    Fragment mCurrent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_right);
        ButterKnife.bind(this);


        BarUtils.setStatusBarLightMode(getWindow(), true);
        BarUtils.setStatusBarColor(getWindow(), Color.WHITE);

        mDrawerLayout.setScrimColor(Color.TRANSPARENT); // 菜单滑动时content不被阴影覆盖
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle(""); // 不显示程序应用名
        mToolBar.setNavigationIcon(R.drawable.ic_menu_black); // 在toolbar最左边添加icon
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        mCurrent = new DrawerHomeFragment();
        replaceFragment(mCurrent);

        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                View mContent = mDrawerLayout.getChildAt(0);
                View mMenu = drawerView;
                float scale = 1 - slideOffset;
                float rightScale = 0.8f + scale * 0.2f;
                float leftScale = 0.5f + slideOffset * 0.5f;
                mMenu.setAlpha(leftScale);
                mMenu.setScaleX(leftScale);
                mMenu.setScaleY(leftScale);
                mContent.setPivotX(0);
                mContent.setPivotY(mContent.getHeight() * 1 / 2);
                mContent.setScaleX(rightScale);
                mContent.setScaleY(rightScale);
                mContent.setTranslationX(mMenu.getWidth() * slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                mCard.setRadius(20);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                mCard.setRadius(0);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }

    public void replaceFragment(Fragment fragment) { // 动态加载fragment
        mCurrent = fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_view, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            replaceFragment(mCurrent);
        } else {
            finish();
        }

    }
}
