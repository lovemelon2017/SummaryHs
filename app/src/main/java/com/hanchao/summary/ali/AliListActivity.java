package com.hanchao.summary.ali;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.alipay.sdk.app.AuthTask;
import com.alipay.sdk.app.OpenAuthTask;
import com.alipay.share.sdk.openapi.APAPIFactory;
import com.alipay.share.sdk.openapi.APImageObject;
import com.alipay.share.sdk.openapi.APMediaMessage;
import com.alipay.share.sdk.openapi.APTextObject;
import com.alipay.share.sdk.openapi.APWebPageObject;
import com.alipay.share.sdk.openapi.IAPApi;
import com.alipay.share.sdk.openapi.SendMessageToZFB;
import com.blankj.utilcode.util.ToastUtils;
import com.hanchao.summary.R;
import com.hanchao.summary.ali.dialog.ItemCheckNormalCallBack;
import com.hanchao.summary.ali.dialog.ShareBottomUrlDialog;
import com.hanchao.summary.util.OrderInfoUtil2_0;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AliListActivity extends AppCompatActivity {
    /**
     * 用于支付宝支付业务的入参 app_id。
     */
    public static final String APPID = "2021001168676882";

    private IAPApi api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ali_list);
        api = APAPIFactory.createZFBApi(getApplicationContext(), APPID, false);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ali_login_tv, R.id.ali_share_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ali_login_tv:

                openAuthorScheme();
                break;
            case R.id.ali_share_tv:

                showShare();

                break;
        }
    }

    private void showShare() {
        ShareBottomUrlDialog dialog = new ShareBottomUrlDialog();
        dialog.setListener(new ItemCheckNormalCallBack() {
            @Override
            public void onCancel() {
                dialog.dismiss();
            }

            @Override
            public void onSelect(int position) {
                if (position == 1) {

                    shareWebToZhiFuBao();

                } else if (position == 2) {
                    shareTextToZhiFuBao();

                } else if (position == 3) {

                    shareImageToZhiFuBao();

                } else if (position == 4) {

                    shareFriendToZhiFuBao();
                }
                dialog.dismiss();
            }
        });

        dialog.show(getSupportFragmentManager(), "share");
    }

    private void shareFriendToZhiFuBao() {
        //初始化一个APWebPageObject对象，组装网页Card内容对象
        APWebPageObject webPageObject = new APWebPageObject();
        webPageObject.webpageUrl = "http://www.baidu.com/";

////初始化APMediaMessage ，组装分享消息对象
        APMediaMessage webMessage = new APMediaMessage();
        webMessage.mediaObject = webPageObject;
        webMessage.title = "分享标题";
        webMessage.description = "分享内容描述";
//网页缩略图的分享支持bitmap和url两种方式，直接通过bitmap传递时bitmap最大为32K
//a）url方式
//webMessage.thumbUrl = "http://www.yoururl.com/thumb.jpg";
//b）Bitmap方式
//webMessage.setThumbImage(bitmap);
//bitmap.recycle();
        webMessage.thumbUrl = "https://img.zcool.cn/community/011ad05e27a173a801216518a5c505.jpg";

//将分享消息对象包装成请求对象
        SendMessageToZFB.Req webReq = new SendMessageToZFB.Req();
        webReq.message = webMessage;
        webReq.transaction = "WebShare" + String.valueOf(System.currentTimeMillis());
//修改请求消息对象的scene场景值为ZFBSceneTimeLine
//9.9.5版本之后的支付宝不需要传此参数，用户会在跳转进支付宝后选择分享场景（好友、动态等）
        webReq.scene = SendMessageToZFB.Req.ZFBSceneTimeLine;

//发送请求
        api.sendReq(webReq);
    }

    private void shareImageToZhiFuBao() {
        APImageObject imageObject = new APImageObject();
//支持三种方式分享图片，本地文件路径，图片二进制流，网上图片url，选取最方便的一个即可
//a）本地图片路径分享
//imageObject.setImagePath("/DCIM/Camera/test.jpg");
//b）图片二进制流分享
//imageObject.imageData = bitmapByte;
//c）图片URL分享
//imageObject.imageUrl = "http://www.yoururl.com/test.jpg";
        imageObject.imageUrl = "https://img.zcool.cn/community/011ad05e27a173a801216518a5c505.jpg";
//初始化一个APMediaMessage对象 ，组装分享消息对象
        APMediaMessage mediaMessage = new APMediaMessage();
        mediaMessage.mediaObject = imageObject;
//将分享消息对象包装成请求对象
        SendMessageToZFB.Req req = new SendMessageToZFB.Req();
        req.message = mediaMessage;
        req.transaction = "ImageShare" + String.valueOf(System.currentTimeMillis());

//发送请求
        api.sendReq(req);
    }

    private void shareWebToZhiFuBao() {
        APWebPageObject webPageObject = new APWebPageObject();
        webPageObject.webpageUrl = "http://www.baidu.com/";
        APMediaMessage webMessage = new APMediaMessage();
        webMessage.title = "我是网页Title";
        webMessage.description = "网页分享内容描述";
        webMessage.mediaObject = webPageObject;
        webMessage.thumbUrl = "https://img.zcool.cn/community/011ad05e27a173a801216518a5c505.jpg";

        //将分享消息对象包装成请求对象
        SendMessageToZFB.Req webReq = new SendMessageToZFB.Req();
        webReq.message = webMessage;
        webReq.transaction = "WebShare" + String.valueOf(System.currentTimeMillis());

        api.sendReq(webReq);
    }

    private void shareTextToZhiFuBao() {
        //初始化一个APTextObject对象
        APTextObject textObject = new APTextObject();
        textObject.text = "小豆豆分享给你的文字";

        //用APTextObject对象初始化一个APMediaMessage对象
        APMediaMessage mediaMessage = new APMediaMessage();
        mediaMessage.mediaObject = textObject;

        //构造一个Req
        SendMessageToZFB.Req req = new SendMessageToZFB.Req();
        req.message = mediaMessage;

        //调用api接口发送消息到支付宝
        api.sendReq(req);

    }

    private void openAuthorScheme() {

        // 传递给支付宝应用的业务参数
        final Map<String, String> bizParams = new HashMap<>();
        bizParams.put("url", "https://authweb.alipay.com/auth?auth_type=PURE_OAUTH_SDK&app_id=2021001168676882&scope=auth_user&state=init");

        // 参见 AndroidManifest 中 <AlipayResultActivity> 的 android:scheme，此两处
        // 必须设置为相同的值。
        final String scheme = "hanchao2020";

        // 唤起授权业务
        final OpenAuthTask task = new OpenAuthTask(this);
        task.execute(
                scheme,    // Intent Scheme
                OpenAuthTask.BizType.AccountAuth, // 业务类型
                bizParams, // 业务参数
                openAuthCallback, // 业务结果回调。注意：此回调必须被你的应用保持强引用
                false); // 是否需要在用户未安装支付宝 App 时，使用 H5 中间页中转

    }


    /**
     * 通用跳转授权业务的回调方法。
     * 此方法在支付宝 SDK 中为弱引用，故你的 App 需要以成员变量等方式保持对 Callback 的强引用，
     * 以免对象被回收。
     * 以局部变量保持对 Callback 的引用是不可行的。
     */
    final OpenAuthTask.Callback openAuthCallback = new OpenAuthTask.Callback() {
        @Override
        public void onResult(int i, String s, Bundle bundle) {
            ToastUtils.showShort(String.format("结果码: %s\n结果信息: %s\n结果数据: %s", i, s, bundleToString(bundle)));
        }
    };

    /**
     * app_id=>2016051801417322
     * result_code=>SUCCESS
     * scope=>auth_user
     * state=>init
     * auth_code=>b539ca4b15e44dedaa7948c591b7ZX75
     *
     * @param bundle
     * @return
     */
    private static String bundleToString(Bundle bundle) {
        if (bundle == null) {
            return "null";
        }
        final StringBuilder sb = new StringBuilder();
        for (String key : bundle.keySet()) {
            sb.append(key).append("=>").append(bundle.get(key)).append("\n");
        }
        return sb.toString();
    }
}
