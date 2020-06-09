package com.hanchao.summary.banner;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ActivityUtils;
import com.hanchao.summary.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 优秀的banner库
 */
public class BannerDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_demo);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.banner_banner_tv1, R.id.banner_banner_tv2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.banner_banner_tv1:
                ActivityUtils.startActivity(YouthBannerActivity.class);
                break;
            case R.id.banner_banner_tv2:
                ActivityUtils.startActivity(BannerViewPagerActivity.class);
                break;
        }
    }
}
