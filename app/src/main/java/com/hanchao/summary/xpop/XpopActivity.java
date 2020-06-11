package com.hanchao.summary.xpop;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ActivityUtils;
import com.hanchao.summary.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class XpopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xpop);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.pop_image, R.id.pop_dialog})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pop_image:
                ActivityUtils.startActivity(XpopImageActivity.class);
                break;
            case R.id.pop_dialog:
                ActivityUtils.startActivity(XpopDialogActivity.class);
                break;
        }
    }
}
