package com.hanchao.summary.xpop;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ToastUtils;
import com.hanchao.summary.R;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.impl.LoadingPopupView;
import com.lxj.xpopup.interfaces.OnConfirmListener;
import com.lxj.xpopup.interfaces.OnInputConfirmListener;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.lxj.xpopup.interfaces.SimpleCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XpopDialogActivity extends AppCompatActivity {
    @BindView(R.id.dialog_tv6)
    TextView tvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xpop_dialog);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.dialog_tv1, R.id.dialog_tv2, R.id.dialog_tv3, R.id.dialog_tv4, R.id.dialog_tv5,
            R.id.dialog_tv6,R.id.dialog_tv7})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_tv1:
                showPop1();
                break;
            case R.id.dialog_tv2:
                showPop2();
                break;
            case R.id.dialog_tv3:
                showPop3();
                break;
            case R.id.dialog_tv4:
                showPop4();
                break;
            case R.id.dialog_tv5:
                showPop5();
                break;
            case R.id.dialog_tv6:
                showPop6();
                break;
            case R.id.dialog_tv7:
                showPop7();
                break;
        }
    }

    private void showPop7() {
        new XPopup.Builder(this)
                .isCenterHorizontal(true)
                .offsetY(200)
                .asCustom(new QQMsgPopup(this))
                .show();
    }

    private void showPop6() {
        new XPopup.Builder(this)
                .hasShadowBg(false)
//                        .isDarkTheme(true)
//                        .popupAnimation(PopupAnimation.NoAnimation) //NoAnimation表示禁用动画
//                        .isCenterHorizontal(true) //是否与目标水平居中对齐
//                        .offsetY(-60)
//                        .popupPosition(PopupPosition.Top) //手动指定弹窗的位置
                .atView(tvView)  // 依附于所点击的View，内部会自动判断在上方或者下方显示
                .asAttachList(new String[]{"分享", "编辑", "不带icon"},
                        new int[]{R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round},
                        new OnSelectListener() {
                            @Override
                            public void onSelect(int position, String text) {
                                ToastUtils.showShort(text);
                            }
                        })
//                        .bindLayout(R.layout.my_custom_attach_popup)
//                        .bindItemLayout(R.layout.my_custom_attach_popup)
                .show();
    }

    private void showPop5() {
        final LoadingPopupView loadingPopup = (LoadingPopupView) new XPopup.Builder(this)
                .asLoading("加载中...")
                .show();
        loadingPopup.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingPopup.setTitle("请稍等...");
            }
        }, 1000);
        loadingPopup.delayDismissWith(3000, new Runnable() {
            @Override
            public void run() {
                ToastUtils.showShort("加载完毕");
            }
        });
    }

    private void showPop4() {
        new XPopup.Builder(this)
//                        .maxWidth(600)
                //  .isDarkTheme(true)
                .asCenterList("请选择一项", new String[]{"条目1", "条目2", "条目3", "条目4"}, null, 1,
                        new OnSelectListener() {
                            @Override
                            public void onSelect(int position, String text) {
                                ToastUtils.showShort(text);
                            }
                        })
//                        .bindLayout(R.layout.my_custom_attach_popup) //自定义布局
                .show();
    }

    private void showPop3() {
        new XPopup.Builder(this)
                //.dismissOnBackPressed(false)
                .autoOpenSoftInput(true)
//                        .autoFocusEditText(false) //是否让弹窗内的EditText自动获取焦点，默认是true
                .isRequestFocus(false)
                //.moveUpToKeyboard(false)   //是否移动到软键盘上面，默认为true
                .asInputConfirm("我是标题", "", "", "请输入内容",
                        new OnInputConfirmListener() {
                            @Override
                            public void onConfirm(String text) {
                                ToastUtils.showShort("输入了:" + text);
                            }
                        })
                .show();
    }

    private void showPop2() {
        new XPopup.Builder(this)
                .setPopupCallback(new SimpleCallback() {
                    @Override
                    public void onCreated() {

                    }

                    @Override
                    public void onShow() {

                    }

                    @Override
                    public void onDismiss() {

                    }

                    //如果你自己想拦截返回按键事件，则重写这个方法，返回true即可
                    @Override
                    public boolean onBackPressed() {
                        ToastUtils.showShort("我拦截的返回按键");
                        return true;
                    }
                }).asConfirm("复用已有布局", "您可以复用项目已有布局，来使用XPopup强大的交互能力和逻辑封装，弹窗的布局完全由你自己控制。\n" +
                        "注意：你自己的布局必须提供一些控件Id，否则XPopup找不到View。\n具体需要提供哪些Id，请查看文档[内置弹窗]一章。",
                "取消", "确定",
                new OnConfirmListener() {
                    @Override
                    public void onConfirm() {

                    }
                }, null, false)
                .bindLayout(R.layout.my_confim_popup) //绑定已有布局
                .show();
    }

    private void showPop1() {
        new XPopup.Builder(this)
//                         .dismissOnTouchOutside(false)
//                         .autoDismiss(false)
//                        .popupAnimation(PopupAnimation.NoAnimation)
                .setPopupCallback(new SimpleCallback() {
                    @Override
                    public void onCreated() {

                    }

                    @Override
                    public void onShow() {

                    }

                    @Override
                    public void onDismiss() {

                    }

                    //如果你自己想拦截返回按键事件，则重写这个方法，返回true即可
                    @Override
                    public boolean onBackPressed() {
                        ToastUtils.showShort("我拦截的返回按键");
                        return true;
                    }
                }).asConfirm("我是标题", "床前明月光，疑是地上霜；举头望明月，低头思故乡。",
                "取消", "确定",
                new OnConfirmListener() {
                    @Override
                    public void onConfirm() {

                    }
                }, null, false)
                .show();
    }
}
