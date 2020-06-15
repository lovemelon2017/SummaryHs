package com.hanchao.summary.gsyplayer;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ActivityUtils;
import com.hanchao.summary.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class GsyDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gsy_demo);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.gsy_play_list_tv1, R.id.gsy_play_details_tv, R.id.gsy_switch_tv, R.id.gsy_list_auto_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gsy_play_list_tv1:
                ActivityUtils.startActivity(GsyListActivity.class);
                break;
            case R.id.gsy_play_details_tv:
                ActivityUtils.startActivity(GsyDetailsActivity.class);
                break;
            case R.id.gsy_switch_tv:
                ActivityUtils.startActivity(SwitchListActivity.class);
                break;
            case R.id.gsy_list_auto_tv:
                ActivityUtils.startActivity(AutoPlayRecyclerViewActivity.class);
                break;
        }
    }
}
