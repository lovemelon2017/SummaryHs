package com.hanchao.summary.banner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.SizeUtils;
import com.hanchao.summary.R;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.indicator.RectangleIndicator;
import com.youth.banner.transformer.AlphaPageTransformer;
import com.youth.banner.transformer.DepthPageTransformer;
import com.youth.banner.transformer.RotateDownPageTransformer;
import com.youth.banner.transformer.RotateUpPageTransformer;
import com.youth.banner.transformer.RotateYTransformer;
import com.youth.banner.transformer.ScaleInTransformer;
import com.youth.banner.transformer.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * github https://github.com/youth5201314/banner
 */
public class YouthBannerActivity extends AppCompatActivity {

    @BindView(R.id.banner_v)
    Banner mBanner;
    @BindView(R.id.tab_sp)
    Spinner mTabSpinner;
    @BindView(R.id.cb_yj)
    CheckBox mRoundCb;
    @BindView(R.id.banner_style)
    Spinner mBannerSpinner;
    @BindView(R.id.page_style)
    Spinner mPageSpinner;
    @BindView(R.id.banner2_v)
    Banner mBanner2;
    @BindView(R.id.cb_indicator)
    CheckBox cbIndicator;

    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youth_banner);
        ButterKnife.bind(this);

        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590757952437&di=74da9d31f6da1828442f65e377d2f906&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F14%2F75%2F01300000164186121366756803686.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590757952437&di=67a8aabd5df966661064a565f9ee133e&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F64%2F76%2F20300001349415131407760417677.jpg");
        list.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2901968400,3820292974&fm=26&gp=0.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591015250579&di=a40eb5686b77fb1fdb74c6a6db4d6180&imgtype=0&src=http%3A%2F%2Fimages.ttkxh.com%2Fstorage%2Fjoke%2Fimage%2F2018%2F10%2F08%2FIxtkzMAQGeWpybL0FvrK93jOf1539012060.jpg");

        mTabSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changeBannerStyle(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mRoundCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mBanner.setBannerRound(SizeUtils.dp2px(10));
                } else {
                    mBanner.setBannerRound(0);
                }
            }
        });

        mBannerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changeBannerAdmin(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mPageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changePageAnim(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //实现1号店和淘宝头条类似的效果
        mBanner2.setAdapter(new TopLineAdapter(DataBean.getTestData2()))
                .setOrientation(Banner.VERTICAL)
                .setPageTransformer(new ZoomOutPageTransformer())
                .setOnBannerListener((data, position) -> {
                });
        cbIndicator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                  mBanner.setIndicator(new NumIndicator(YouthBannerActivity.this));
                } else {
                    mBanner.setIndicator(new CircleIndicator(YouthBannerActivity.this));
                }
            }
        });


    }

    private void changePageAnim(int position) {

        BannerImageAdapter bannerAdapter = new BannerImageAdapter(list);
        mBanner.setAdapter(bannerAdapter);

        switch (position) {
            case 0:
                mBanner.setPageTransformer(new AlphaPageTransformer());
                break;
            case 1:
                mBanner.setPageTransformer(new DepthPageTransformer());
                break;
            case 2:
                mBanner.setPageTransformer(new RotateDownPageTransformer());
                break;
            case 3:
                mBanner.setPageTransformer(new RotateUpPageTransformer());
                break;
            case 4:
                mBanner.setPageTransformer(new RotateYTransformer());
                break;
            case 5:
                mBanner.setPageTransformer(new ScaleInTransformer());
                break;
            case 6:
                mBanner.setPageTransformer(new ZoomOutPageTransformer());
                break;
        }
        mBanner.start();

    }

    private void changeBannerAdmin(int position) {
        BannerImageAdapter bannerAdapter = new BannerImageAdapter(list);
        mBanner.setAdapter(bannerAdapter);
        switch (position) {
            case 0:
                mBanner.setBannerGalleryMZ(0, 0);
                mBanner.setBannerGalleryEffect(0, 0);
                break;
            case 1:
                mBanner.setBannerGalleryEffect(18, 10);
                mBanner.addPageTransformer(new AlphaPageTransformer());
                break;
            case 2:
                mBanner.setBannerGalleryMZ(20);

                break;
        }
        mBanner.start();
    }

    /**
     * 轮播图Indicator样式
     *
     * @param position
     */
    private void changeBannerStyle(int position) {
        switch (position) {
            case 0:
                initDefaultBannerStyle(true, false, false, false, false, false, false, false, false);
                break;
            case 1:
                initDefaultBannerStyle(false, true, false, false, false, false, false, false, false);
                break;
            case 2:
                initDefaultBannerStyle(false, false, true, false, false, false, false, false, false);
                break;
            case 3:
                initDefaultBannerStyle(false, false, false, true, false, false, false, false, false);
                break;
            case 4:
                initDefaultBannerStyle(false, false, false, false, true, false, false, false, false);
                break;
            case 5:
                initDefaultBannerStyle(false, false, false, false, false, true, false, false, false);
                break;
            case 6:
                initDefaultBannerStyle(false, false, false, false, false, false, true, false, false);
                break;
            case 7:
                initDefaultBannerStyle(false, false, false, false, false, false, false, true, false);
                break;
            case 8:
                initDefaultBannerStyle(false, false, false, false, false, false, false, false, true);
                break;

        }
    }

    private void initDefaultBannerStyle(boolean isCircleIndicator, boolean isLine, boolean isColor, boolean isSize, boolean isMargin,
                                        boolean selected, boolean isLeft, boolean isCenter, boolean isRight) {
        BannerImageAdapter bannerAdapter = new BannerImageAdapter(list);
        mBanner.setAdapter(bannerAdapter);
        if (isCircleIndicator) {
            mBanner.setIndicator(new CircleIndicator(this));
        }
        if (isLine) {
            mBanner.setIndicator(new RectangleIndicator(this));
        }

        if (isColor) {
            mBanner.setIndicatorSelectedColor(getResources().getColor(R.color.cl_indicator_select));
            mBanner.setIndicatorNormalColor(getResources().getColor(R.color.cl_indicator_unselect));
        }
        if (isSize) {
            mBanner.setIndicatorWidth(SizeUtils.dp2px(7), SizeUtils.dp2px(10));
        }
        if (isMargin) {
            mBanner.setIndicatorSpace(SizeUtils.dp2px(10));
        }
        if (selected) {
            mBanner.setIndicatorSelectedWidth(SizeUtils.dp2px(12));
            mBanner.setIndicatorNormalWidth(SizeUtils.dp2px(6));
        }
        if (isLeft) {
            mBanner.setIndicatorGravity(IndicatorConfig.Direction.LEFT);
        }
        if (isCenter) {
            mBanner.setIndicatorGravity(IndicatorConfig.Direction.CENTER);
        }
        if (isRight) {
            mBanner.setIndicatorGravity(IndicatorConfig.Direction.RIGHT);
        }

        mBanner.start();
    }


    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        mBanner.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //停止轮播
        mBanner.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁
        mBanner.destroy();
    }

}
