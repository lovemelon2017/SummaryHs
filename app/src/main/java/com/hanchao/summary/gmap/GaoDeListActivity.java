package com.hanchao.summary.gmap;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.AmapNaviType;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapNaviLocation;
import com.blankj.utilcode.util.ActivityUtils;
import com.hanchao.summary.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class GaoDeListActivity extends AppCompatActivity implements INaviInfoCallback {

    LatLng p1 = new LatLng(39.993266, 116.473193);//首开广场
    LatLng p2 = new LatLng(39.917337, 116.397056);//故宫博物院
    LatLng p3 = new LatLng(39.904556, 116.427231);//北京站
    LatLng p4 = new LatLng(39.773801, 116.368984);//新三余公园(南5环)
    LatLng p5 = new LatLng(40.041986, 116.414496);//立水桥(北5环)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gao_de_list);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.gd_map_tv, R.id.indoor_map_tv, R.id.heat_map_tv, R.id.route_mat})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gd_map_tv:
                ActivityUtils.startActivity(GaoDeMapActivity.class);
                break;
            case R.id.indoor_map_tv:
                ActivityUtils.startActivity(InDoorMapActivity.class);
                break;
            case R.id.heat_map_tv:
                ActivityUtils.startActivity(HeatMapActivity.class);
                break;
            case R.id.route_mat:

                AmapNaviParams params = new AmapNaviParams(new Poi("北京站", p3, ""), null, new Poi("故宫博物院", p2, ""), AmapNaviType.DRIVER);
                params.setUseInnerVoice(true);
                AmapNaviPage.getInstance().showRouteActivity(getApplicationContext(), params, GaoDeListActivity.this);

                break;
        }

    }

    /**
     * 导航
     */

    @Override
    public void onInitNaviFailure() {

        Log.e("han","onInitNaviFailure");
    }

    @Override
    public void onGetNavigationText(String s) {
        Log.e("han","onGetNavigationText"+s);
    }

    @Override
    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

    }

    @Override
    public void onArriveDestination(boolean b) {
        Log.e("han","onArriveDestination"+b);
    }

    @Override
    public void onStartNavi(int i) {
        Log.e("han","onStartNavi"+i);
    }

    @Override
    public void onCalculateRouteSuccess(int[] ints) {
        Log.e("han","onCalculateRouteSuccess");
    }

    @Override
    public void onCalculateRouteFailure(int i) {
        Log.e("han","onCalculateRouteFailure");
    }

    @Override
    public void onStopSpeaking() {

    }

    @Override
    public void onReCalculateRoute(int i) {

    }

    @Override
    public void onExitPage(int i) {

    }

    @Override
    public void onStrategyChanged(int i) {

    }

    @Override
    public View getCustomNaviBottomView() {
        return null;
    }

    @Override
    public View getCustomNaviView() {
        return null;
    }

    @Override
    public void onArrivedWayPoint(int i) {

    }

    @Override
    public void onMapTypeChanged(int i) {

    }

    @Override
    public View getCustomMiddleView() {
        return null;
    }

    @Override
    public void onNaviDirectionChanged(int i) {

    }

    @Override
    public void onDayAndNightModeChanged(int i) {

    }

    @Override
    public void onBroadcastModeChanged(int i) {

    }

    @Override
    public void onScaleAutoChanged(boolean b) {

    }
}
