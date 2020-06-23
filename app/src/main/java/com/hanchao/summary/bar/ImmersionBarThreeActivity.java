package com.hanchao.summary.bar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.hanchao.summary.R;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImmersionBarThreeActivity extends AppCompatActivity {

    @BindView(R.id.view_need_offset)
    View viewNeedOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersion_bar_three);
        ButterKnife.bind(this);
        StatusBarUtil.setTranslucentForImageView(this, 0,viewNeedOffset);
    }
}
