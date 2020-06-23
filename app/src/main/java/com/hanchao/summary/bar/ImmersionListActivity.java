package com.hanchao.summary.bar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.hanchao.summary.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImmersionListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersion_list);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bar1_tv, R.id.bar2_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bar1_tv:
                ActivityUtils.startActivity(ImmersionBarActivity.class);
                break;
            case R.id.bar2_tv:
                ActivityUtils.startActivity(ImmersionBarThreeActivity.class);
                break;
        }
    }
}
