package com.hanchao.summary.gsyplayer;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hanchao.summary.R;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

public class GsyListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public GsyListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        StandardGSYVideoPlayer gsyVideoPlayer = helper.getView(R.id.stand_player);
        int position = helper.getAbsoluteAdapterPosition();

        gsyVideoPlayer.setUp(item, true, null, null, "Title");

        //增加封面
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.ic_bg);
        gsyVideoPlayer.setThumbImageView(imageView);

//增加title
        gsyVideoPlayer.getTitleTextView().setVisibility(View.GONE);
//设置返回键
        gsyVideoPlayer.getBackButton().setVisibility(View.GONE);
//设置全屏按键功能
        gsyVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gsyVideoPlayer.startWindowFullscreen(mContext, false, true);
            }
        });
//防止错位设置
        gsyVideoPlayer.setPlayTag(TAG);
        gsyVideoPlayer.setPlayPosition(position);
//是否根据视频尺寸，自动选择竖屏全屏或者横屏全屏
        gsyVideoPlayer.setAutoFullWithSize(true);
//音频焦点冲突时是否释放
        gsyVideoPlayer.setReleaseWhenLossAudio(false);
//全屏动画
        gsyVideoPlayer.setShowFullAnimation(true);
//小屏时不触摸滑动
        gsyVideoPlayer.setIsTouchWiget(false);
    }
}
