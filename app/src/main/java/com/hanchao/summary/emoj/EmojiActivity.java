package com.hanchao.summary.emoj;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hanchao.summary.R;

import butterknife.ButterKnife;

public class EmojiActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji);
        ButterKnife.bind(this);

    }
}
