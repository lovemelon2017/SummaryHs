package com.hanchao.summary.banner;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.hanchao.summary.R;
import com.zhpan.bannerview.BaseViewHolder;

public class NetViewHolder extends BaseViewHolder<String> {

    public NetViewHolder(@NonNull View itemView) {
        super(itemView);

    }

    @Override
    public void bindData(String data, int position, int pageSize) {
        ImageView imageView = findView(R.id.banner_image);
        Glide.with(imageView).load(data).into(imageView);
    }
}
