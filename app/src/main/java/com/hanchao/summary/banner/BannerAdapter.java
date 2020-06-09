package com.hanchao.summary.banner;

import android.view.View;

import com.hanchao.summary.R;
import com.zhpan.bannerview.BaseBannerAdapter;
import com.zhpan.bannerview.BaseViewHolder;

/**
 * lovely_melon
 * 2020/3/10
 */
public class BannerAdapter extends BaseBannerAdapter<String, NetViewHolder> {


    @Override
    protected void onBind(NetViewHolder holder, String data, int position, int pageSize) {
        holder.bindData(data,position,pageSize);
    }

    @Override
    public NetViewHolder createViewHolder(View itemView, int viewType) {
        return new NetViewHolder(itemView);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_banner;
    }
}
