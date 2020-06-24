package com.hanchao.summary.ali.dialog;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.hanchao.summary.R;


/**
 * lovely_melon_2019
 */
public class ShareBottomUrlDialog extends DialogFragment {

    TextView tvChat;
    TextView tvQQ;
    TextView tvChatFriend;
    TextView tvZone;
    TextView tvCancel;

    ItemCheckNormalCallBack listener;

    public void setListener(ItemCheckNormalCallBack listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_dialog_share, null);
        tvChat = view.findViewById(R.id.tv_wechat_share);
        tvQQ = view.findViewById(R.id.tv_qq_share);
        tvChatFriend = view.findViewById(R.id.tv_wechat_friend_share);
        tvZone = view.findViewById(R.id.tv_share_qzone);
        tvCancel = view.findViewById(R.id.tv_cancle_dissmiss);

        tvChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onSelect(1);
                }
            }
        });
        tvQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onSelect(2);
                }
            }
        });
        tvChatFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onSelect(3);
                }
            }
        });
        tvZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onSelect(4);
                }
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onCancel();
                }
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        // 如果不设置这句代码, 那么弹框就会与四边都有一定的距离
        window.setBackgroundDrawableResource(android.R.color.transparent);
        // 设置动画
        window.setWindowAnimations(R.style.bottom_dialog);
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        // 如果不设置宽度,那么即使你在布局中设置宽度为 match_parent 也不会起作用
        params.width = getResources().getDisplayMetrics().widthPixels;
        window.setAttributes(params);
    }
}
