package com.hanchao.summary.coor;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SizeUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.hanchao.summary.R;
import com.hanchao.summary.rvandrv.AccessBean;
import com.hanchao.summary.rvandrv.AccessListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.blankj.utilcode.util.BarUtils.getStatusBarHeight;

public class CoordinatorActivity extends AppCompatActivity {
    @BindView(R.id.rv_rv)
    RecyclerView mRv;
    AccessListAdapter mAdapter;
    @BindView(R.id.appbar)
    AppBarLayout appBar;

    @BindView(R.id.toolbar)
    Toolbar mTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        ButterKnife.bind(this);
        initRv();

        initToolBar();
        final int alphaMaxOffset = SizeUtils.dp2px(150);
        mTool.getBackground().setAlpha(0);
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                // 设置 toolbar 背景
                if (verticalOffset > -alphaMaxOffset) {
                    mTool.getBackground().setAlpha(255 * -verticalOffset / alphaMaxOffset);
                } else {
                    mTool.getBackground().setAlpha(255);
                }
            }
        });


    }

    private void initToolBar() {
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            if (toolbar != null) {
                // 沉浸模式
                int statusBarHeight = getStatusBarHeight();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    openAndroidLStyle();

                    toolbar.setPadding(0, statusBarHeight, 0, 0);
                    toolbar.getLayoutParams().height = SizeUtils.dp2px(46) + statusBarHeight;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initRv() {
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new AccessListAdapter(R.layout.item_access_lay);
        mRv.setAdapter(mAdapter);


        List<AccessBean> beans = new ArrayList<>();
        AccessBean bean1 = new AccessBean();
        bean1.setTitle("商品名称");
        beans.add(bean1);
        AccessBean bean2 = new AccessBean();
        bean2.setTitle("京东打篮球");
        beans.add(bean2);
        AccessBean bean3 = new AccessBean();
        bean3.setTitle("小逗比");
        beans.add(bean3);
        AccessBean bean4 = new AccessBean();
        bean4.setTitle("郑州大学");
        beans.add(bean4);
        mAdapter.setNewData(beans);


    }

    /**
     * 开启沉浸式模式支持
     */
    public void openAndroidLStyle() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

}
