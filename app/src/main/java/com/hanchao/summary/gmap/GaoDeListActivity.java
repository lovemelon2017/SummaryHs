package com.hanchao.summary.gmap;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ActivityUtils;
import com.hanchao.summary.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class GaoDeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gao_de_list);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.gd_map_tv,R.id.indoor_map_tv,R.id.heat_map_tv})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.gd_map_tv:
                ActivityUtils.startActivity(GaoDeMapActivity.class);
                break;
            case R.id.indoor_map_tv:
                ActivityUtils.startActivity(InDoorMapActivity.class);
                break;
            case R.id.heat_map_tv:
                ActivityUtils.startActivity(HeatMapActivity.class);
                break;
        }

    }

}
