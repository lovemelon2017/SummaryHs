package com.hanchao.summary.gsyplayer;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hanchao.summary.R;
import com.hanchao.summary.util.SwitchUtil;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

public class GsySwitchListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public GsySwitchListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        SwitchVideo gsyVideoPlayer = helper.getView(R.id.stand_player);

        //防止错位设置
        //增加封面
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.ic_bg);
        gsyVideoPlayer.setThumbImageView(imageView);

       // gsyVideoPlayer.setPlayTag(TAG);
       // gsyVideoPlayer.setPlayPosition(helper.getAbsoluteAdapterPosition());
        SwitchUtil.optionPlayer(gsyVideoPlayer, item, true, "这是title");
        gsyVideoPlayer.setUpLazy(item, true, null, null, "这是title");


    }
}
