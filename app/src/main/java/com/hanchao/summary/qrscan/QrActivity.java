package com.hanchao.summary.qrscan;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.hanchao.summary.R;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;
import com.yzq.zxinglibrary.encode.CodeCreator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QrActivity extends AppCompatActivity {
    @BindView(R.id.scan_result_tv)
    TextView tvResult;
    @BindView(R.id.logo_cb)
    CheckBox mBox;
    @BindView(R.id.qr_iv)
    ImageView ivLogoQr;

    public static final int REQUEST_CODE_SCAN = 10001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        ButterKnife.bind(this);

        /**
         * i相机权限
         */
        requestCamera();
    }

    private void requestCamera() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = new String[]{Manifest.permission.CAMERA};
            if (ContextCompat.checkSelfPermission(this, permissions[0]) !=
                    PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, permissions, 101);
            }
        }
    }

    @OnClick({R.id.qr_scan_tv, R.id.qr_get_iv})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qr_scan_tv:
                tvResult.setText("");
                /**
                 *ZxingConfig config = new ZxingConfig();
                 * config.setPlayBeep(true);//是否播放扫描声音 默认为true
                 * config.setShake(true);//是否震动  默认为true
                 * config.setDecodeBarCode(true);//是否扫描条形码 默认为true
                 * config.setReactColor(R.color.colorAccent);//设置扫描框四个角的颜色 默认为白色
                 * config.setFrameLineColor(R.color.colorAccent);//设置扫描框边框颜色 默认无色
                 * config.setScanLineColor(R.color.colorAccent);//设置扫描线的颜色 默认白色
                 * config.setFullScreenScan(false);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
                 * intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                 */
                Intent intent = new Intent(this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SCAN);
                break;
            case R.id.qr_get_iv:

                getQrImage();

                break;
        }
    }

    private void getQrImage() {
        String contentEtString = "我是生成的信息";
        if (mBox.isChecked()) {
            Bitmap logo = BitmapFactory.decodeResource(getResources(), R.drawable.ic_study_logo);
            Bitmap bitmap = CodeCreator.createQRCode(contentEtString, 400, 400, logo);
            if (bitmap != null) {
                ivLogoQr.setImageBitmap(bitmap);
            }
        } else {
            Bitmap bitmap = CodeCreator.createQRCode(contentEtString, 400, 400, null);
            if (bitmap != null) {
                ivLogoQr.setImageBitmap(bitmap);
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);
                tvResult.setText("扫描结果: " + content);

            }
        }
    }


}
