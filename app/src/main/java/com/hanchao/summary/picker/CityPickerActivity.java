package com.hanchao.summary.picker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ToastUtils;
import com.hanchao.summary.R;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;
import com.zaaach.citypicker.model.LocatedCity;

import java.util.ArrayList;
import java.util.List;

public class CityPickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_picker);

        List<HotCity> hotCities = new ArrayList<>();
        hotCities.add(new HotCity("北京", "北京", "101010100")); //code为城市代码
        hotCities.add(new HotCity("上海", "上海", "101020100"));
        hotCities.add(new HotCity("广州", "广东", "101280101"));
        hotCities.add(new HotCity("深圳", "广东", "101280601"));
        hotCities.add(new HotCity("杭州", "浙江", "101210101"));

        CityPicker.from(this) //activity或者fragment
                .enableAnimation(true)    //启用动画效果，默认无
                .setLocatedCity(new LocatedCity("杭州", "浙江", "101210101"))
                .setHotCities(hotCities)    //指定热门城市
                .setOnPickListener(new OnPickListener() {
                    @Override
                    public void onPick(int position, City data) {
                        ToastUtils.showShort("您选择了:" + data.getName() + "  " + data.getProvince());
                        finish();
                    }

                    @Override
                    public void onCancel() {
                        finish();
                    }

                    @Override
                    public void onLocate() {
                        //定位接口，需要APP自身实现，这里模拟一下定位
                    }
                })
                .show();
    }
}
