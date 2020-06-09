package com.hanchao.summary.rvandrv;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hanchao.summary.R;

import java.util.List;

public class ImageItemAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public ImageItemAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        Glide.with(mContext).load(item).into((ImageView) helper.getView(R.id.item_iv));
    }
}
