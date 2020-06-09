package com.hanchao.summary.rvandrv;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hanchao.summary.R;
import com.hanchao.summary.util.GlideEngine;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerDoubleActivity extends AppCompatActivity {

    @BindView(R.id.rv_rv)
    RecyclerView mRv;
    AccessListAdapter mAdapter;
    int positionChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_double);
        ButterKnife.bind(this);
        initRv();

        loadData();
    }

    private void loadData() {
        List<AccessBean> beans = new ArrayList<>();
        AccessBean bean1 = new AccessBean();
        bean1.setTitle("商品名称。。。咋样");
        beans.add(bean1);
        AccessBean bean2 = new AccessBean();
        bean2.setTitle("京东打篮球，很好么，不是我说，谁也打不过我，哈哈哈哈哈哈哈哈哈");
        beans.add(bean2);
        AccessBean bean3 = new AccessBean();
        bean3.setTitle("小逗比");
        beans.add(bean3);
        mAdapter.setNewData(beans);
    }

    private void initRv() {
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new AccessListAdapter(R.layout.item_access_lay);
        mRv.setAdapter(mAdapter);


        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                positionChecked = position;
                AccessBean bean = (AccessBean) adapter.getData().get(position);
                switch (view.getId()) {
                    case R.id.pub_ll:
                        //选择本地图片
                        openImages();
                        break;
                    case R.id.rating1:
                        SimpleRatingBar ratingBar1 = (SimpleRatingBar) view;
                        float rating = ratingBar1.getRating();
                        bean.setRatingNum1((int) rating);
                        mAdapter.notifyDataSetChanged();

                        break;
                    case R.id.rating2:
                        SimpleRatingBar ratingBar2 = (SimpleRatingBar) view;
                        float rating2 = ratingBar2.getRating();
                        bean.setRatingNum2((int) rating2);
                        mAdapter.notifyDataSetChanged();
                        break;
                    case R.id.tv_confirm:
                        ToastUtils.showShort("您提交了: " + position);
                        break;
                }

            }
        });

    }

    private void openImages() {

        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .imageEngine(GlideEngine.createGlideEngine())// 外部传入图片加载引擎，必传项
                .maxSelectNum(5)
                .isEnableCrop(true)
                .withAspectRatio(1, 1)
                .showCropFrame(true)
                .showCropGrid(true)
                .isAndroidQTransform(false)
                .minimumCompressSize(200)
                .forResult(PictureConfig.CHOOSE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<String> locationImages = new ArrayList<>();//本地图片数据
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < selectList.size(); i++) {
                        //上传图片
                        LocalMedia media = selectList.get(i);
                        String qToPath = media.getAndroidQToPath();
                        if (TextUtils.isEmpty(qToPath)) {
                            String compressPath = media.getCutPath();
                            locationImages.add(compressPath);
                        } else {
                            String compressPath = media.getAndroidQToPath();
                            locationImages.add(compressPath);
                        }
                    }
                    AccessBean accessBean = mAdapter.getData().get(positionChecked);
                    accessBean.setImages(locationImages);
                    mAdapter.notifyDataSetChanged();
                    break;

            }
        }
    }
}
