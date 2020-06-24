package com.hanchao.summary.apshare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.alipay.share.sdk.openapi.APAPIFactory;
import com.alipay.share.sdk.openapi.BaseReq;
import com.alipay.share.sdk.openapi.BaseResp;
import com.alipay.share.sdk.openapi.IAPAPIEventHandler;
import com.alipay.share.sdk.openapi.IAPApi;
import com.blankj.utilcode.util.ToastUtils;

public class ShareEntryActivity extends Activity implements IAPAPIEventHandler {
    private IAPApi api;
    public static final String APPID = "2021001168676882";

    /**
     * 2021001168676882
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = APAPIFactory.createZFBApi(getApplicationContext(), APPID, false);
        Intent intent = getIntent();
        api.handleIntent(intent, this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        String result = "";

        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                result = "分享成功";
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                result = "分享取消";
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                result = "分享鉴权失败";
                break;
            case BaseResp.ErrCode.ERR_SENT_FAILED:
                result = "分享失败";
                break;
            default:
                result = "未知错误";
                break;
        }
        ToastUtils.showShort(result);
        finish();
    }
}
