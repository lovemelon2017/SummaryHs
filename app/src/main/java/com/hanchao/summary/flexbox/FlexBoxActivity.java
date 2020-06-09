package com.hanchao.summary.flexbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.android.flexbox.FlexboxLayout;
import com.hanchao.summary.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlexBoxActivity extends AppCompatActivity {
    @BindView(R.id.flex_v)
    FlexboxLayout flexboxLayout;

    String tabs[] = {"郑州大学", "北京师范大学", "清华大学", "北京航天航天大学", "郑州华北水利水电大学", "上海", "复旦大学"};
    List<TextView> listText = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flex_box);
        ButterKnife.bind(this);

        initData();

    }

    private void initData() {


        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = (int) v.getTag();

                ToastUtils.showShort("您选择了: " + tabs[tag]);
            }
        };

        for (int i = 0; i < tabs.length; i++) {
            TextView textView = new TextView(FlexBoxActivity.this);
            textView.setBackgroundResource(R.drawable.shape_text_flex2);
            textView.setText(tabs[i]);
            textView.setTag(i);
            listText.add(textView);
            FlexboxLayout.LayoutParams params = new FlexboxLayout.LayoutParams(FlexboxLayout.LayoutParams.WRAP_CONTENT,
                    FlexboxLayout.LayoutParams.WRAP_CONTENT);
            flexboxLayout.addView(textView, params);
            textView.setOnClickListener(clickListener);
        }

    }
}
