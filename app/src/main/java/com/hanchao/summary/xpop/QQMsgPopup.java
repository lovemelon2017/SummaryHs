package com.hanchao.summary.xpop;

import android.content.Context;

import androidx.annotation.NonNull;

import com.hanchao.summary.R;
import com.lxj.xpopup.core.PositionPopupView;

/**
 * Description:
 * Create by dance, at 2019/6/14
 */
public class QQMsgPopup extends PositionPopupView {
    public QQMsgPopup(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popup_qq_msg;
    }
}
