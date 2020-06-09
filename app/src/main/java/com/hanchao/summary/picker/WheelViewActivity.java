package com.hanchao.summary.picker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.blankj.utilcode.util.ToastUtils;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.hanchao.summary.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WheelViewActivity extends AppCompatActivity {

    @BindView(R.id.wheel_v)
    WheelView wheelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_view_acitivity);
        ButterKnife.bind(this);
        wheelView.setTextSize(20);
        wheelView.setLineSpacingMultiplier(2f);
        // wheelView.setDividerWidth(6);
        wheelView.setDividerType(WheelView.DividerType.CIRCLE);

        final List<String> mOptionsItems = new ArrayList<>();
        mOptionsItems.add("10");
        mOptionsItems.add("20");
        mOptionsItems.add("30");
        mOptionsItems.add("40");
        mOptionsItems.add("50");
        mOptionsItems.add("60");
        mOptionsItems.add("70");

        wheelView.setAdapter(new ArrayWheelAdapter(mOptionsItems));
        wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                ToastUtils.showShort(mOptionsItems.get(index));
            }
        });
    }
}
