package com.hanchao.summary;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.blankj.utilcode.util.ActivityUtils;
import com.hanchao.summary.banner.BannerDemoActivity;
import com.hanchao.summary.coor.CoordinatorActivity;
import com.hanchao.summary.flexbox.FlexBoxActivity;
import com.hanchao.summary.gmap.GaoDeListActivity;
import com.hanchao.summary.gsyplayer.GsyDemoActivity;
import com.hanchao.summary.multiple.MultipleActivity;
import com.hanchao.summary.picker.DatePickerActivity;
import com.hanchao.summary.rvandrv.RecyclerDoubleActivity;
import com.hanchao.summary.sb.SwitchButtonActivity;
import com.hanchao.summary.wxdemo.WxPicActivity;
import com.hanchao.summary.xpop.XpopActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        requestStore();
    }

    private void requestStore() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE};
            if (ContextCompat.checkSelfPermission(this, permissions[0]) !=
                    PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, permissions, 100);
            } else {
                requestCamera();
            }
        }

    }

    private void requestCamera() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = new String[]{Manifest.permission.CAMERA};
            if (ContextCompat.checkSelfPermission(this, permissions[0]) !=
                    PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, permissions, 101);
            } else {
                requestRecord();
            }
        }
    }

    private void requestRecord() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = new String[]{Manifest.permission.RECORD_AUDIO};
            if (ContextCompat.checkSelfPermission(this, permissions[0])
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, permissions, 102);
            } else {

            }
        }

    }


    @OnClick({R.id.main_banner_tv, R.id.main_flex_tv, R.id.main_duo_tv, R.id.main_rv_rv_tv,
            R.id.main_picker, R.id.main_switch, R.id.main_coor, R.id.main_wx_video, R.id.main_pop,
            R.id.main_gsy_player, R.id.main_gd_map})
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
            case R.id.main_switch:
                ActivityUtils.startActivity(SwitchButtonActivity.class);
                break;
            case R.id.main_coor:
                ActivityUtils.startActivity(CoordinatorActivity.class);
                break;
            case R.id.main_wx_video:
                ActivityUtils.startActivity(WxPicActivity.class);
                break;
            case R.id.main_pop:
                ActivityUtils.startActivity(XpopActivity.class);
                break;
            case R.id.main_gsy_player:
                ActivityUtils.startActivity(GsyDemoActivity.class);
                break;
            case R.id.main_gd_map:
                ActivityUtils.startActivity(GaoDeListActivity.class);
                break;
        }
    }

}
