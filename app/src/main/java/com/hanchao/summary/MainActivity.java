package com.hanchao.summary;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ActivityUtils;
import com.hanchao.summary.banner.BannerDemoActivity;
import com.hanchao.summary.flexbox.FlexBoxActivity;
import com.hanchao.summary.multiple.MultipleActivity;
import com.hanchao.summary.picker.DatePickerActivity;
import com.hanchao.summary.rvandrv.RecyclerDoubleActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.main_banner_tv, R.id.main_flex_tv, R.id.main_duo_tv, R.id.main_rv_rv_tv,
            R.id.main_picker})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_banner_tv:
                ActivityUtils.startActivity(BannerDemoActivity.class);
                break;
            case R.id.main_flex_tv:
                ActivityUtils.startActivity(FlexBoxActivity.class);
                break;
            case R.id.main_duo_tv:
                ActivityUtils.startActivity(MultipleActivity.class);
                break;
            case R.id.main_rv_rv_tv:
                ActivityUtils.startActivity(RecyclerDoubleActivity.class);
                break;
            case R.id.main_picker:
                ActivityUtils.startActivity(DatePickerActivity.class);
                break;
        }
    }

}
