package com.hanchao.summary.banner;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hanchao.summary.R;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.bannerview.constants.IndicatorGravity;
import com.zhpan.bannerview.constants.PageStyle;
import com.zhpan.indicator.enums.IndicatorSlideMode;
import com.zhpan.indicator.enums.IndicatorStyle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BannerViewPagerActivity extends AppCompatActivity {
    List<String> list = new ArrayList<>();
    private static final int REQUEST_CODE_CHOOSE = 23;

    @BindView(R.id.banner_v)
    BannerViewPager<String, NetViewHolder> mBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_view_pager);
        ButterKnife.bind(this);
        list.add("https://img.zcool.cn/community/011ad05e27a173a801216518a5c505.jpg");
        list.add("https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg");
        list.add("https://img.zcool.cn/community/013c7d5e27a174a80121651816e521.jpg");
        list.add("https://img.zcool.cn/community/01b8ac5e27a173a80120a895be4d85.jpg");

        initBanner();

    }

    private void initBanner() {
        BannerAdapter bannerAdapter = new BannerAdapter();
        mBanner.setAdapter(bannerAdapter)
                .setIndicatorGravity(IndicatorGravity.CENTER)
                .setIndicatorStyle(IndicatorStyle.CIRCLE)
                .setRoundCorner(20)
                .setIndicatorMargin(10, 10, 10, 10)
                .setIndicatorSlideMode(IndicatorSlideMode.SMOOTH)
                .setIndicatorSliderColor(Color.GRAY, Color.GREEN)
                .setPageStyle(PageStyle.MULTI_PAGE_OVERLAP)
                .create(list);
    }

    @OnClick(R.id.open_image_tv)
    public void onClick() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
