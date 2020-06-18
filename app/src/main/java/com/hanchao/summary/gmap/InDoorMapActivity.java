package com.hanchao.summary.gmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.blankj.utilcode.util.ToastUtils;
import com.hanchao.summary.R;
import com.hanchao.summary.view.IndoorFloorSwitchView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InDoorMapActivity extends AppCompatActivity {

    @BindView(R.id.mapview)
    MapView mapView;
    @BindView(R.id.indoorview)
    IndoorFloorSwitchView floorSwitchView;
    private AMap aMap;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_door_map);
        ButterKnife.bind(this);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        init();

        // 设置楼层控制控件监听
        floorSwitchView.setOnIndoorFloorSwitchListener(new MyIndoorSwitchViewAdapter());


        // 设置室内地图回调监听
        aMap.setOnIndoorBuildingActiveListener(new AMap.OnIndoorBuildingActiveListener() {
            @Override
            public void OnIndoorBuilding(final IndoorBuildingInfo indoorBuildingInfo) {

                if(indoorBuildingInfo != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            floorSwitchView.setVisible(true);
                            //相同室内图，不需要替换楼层总数，只需要设置选中的楼层即可
                            if(mIndoorBuildingInfo == null || !mIndoorBuildingInfo.poiid.equals(indoorBuildingInfo.poiid)) {
                                floorSwitchView
                                        .setItems(indoorBuildingInfo.floor_names);
                                floorSwitchView
                                        .setSeletion(indoorBuildingInfo.activeFloorName);
                            }


                            mIndoorBuildingInfo = indoorBuildingInfo;
                        }
                    });
                } else {

                    floorSwitchView.setVisible(false);
                }
            }
        });


        aMap.setOnMapLoadedListener(new AMap.OnMapLoadedListener() {

            @Override
            public void onMapLoaded() {
                // 室内地图默认不显示，这里把它设置成显示
                aMap.showIndoorMap(true);
                // 关闭SDK自带的室内地图控件
                aMap.getUiSettings().setIndoorSwitchEnabled(false);

                //移动到有室内地图的地方,放大级别才可以看见
                aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.91095, 116.37296), 19));

            }
        });
    }


    /**
     * 初始化AMap对象
     */
    private void init() {
        if (aMap == null) {
            aMap = mapView.getMap();

            aMap.getUiSettings().setScaleControlsEnabled(true);
//            MyLocationStyle myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
//            myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
//            aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
////aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
//            aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
//            myLocationStyle.showMyLocation(true);

        }
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    /**
     * 室内地图信息
     */
    IndoorBuildingInfo mIndoorBuildingInfo = null;


    private class MyIndoorSwitchViewAdapter implements
            IndoorFloorSwitchView.OnIndoorFloorSwitchListener {

        @Override
        public void onSelected(final int selectedIndex) {
            ToastUtils.showShort("selectedIndex = " + selectedIndex);
            if (mIndoorBuildingInfo != null) {
                mIndoorBuildingInfo.activeFloorIndex = mIndoorBuildingInfo.floor_indexs[selectedIndex];
                mIndoorBuildingInfo.activeFloorName = mIndoorBuildingInfo.floor_names[selectedIndex];

                aMap.setIndoorBuildingInfo(mIndoorBuildingInfo);

            }
        }

    }
}
