package com.hanchao.summary.rvandrv;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hanchao.summary.R;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.List;

public class AccessListAdapter extends BaseQuickAdapter<AccessBean, BaseViewHolder> {
    RecyclerView mRv;
    ImageItemAdapter adapter;

    public AccessListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, AccessBean item) {
        mRv = helper.getView(R.id.item_rv);
        SimpleRatingBar ratingBar1 = helper.getView(R.id.rating1);
        SimpleRatingBar ratingBar2 = helper.getView(R.id.rating2);
        String title = item.getTitle();
        helper.setText(R.id.goods_title_tv, title);

        List<String> images = item.getImages();
        if (images != null) {
            LinearLayoutManager manager = new LinearLayoutManager(mContext);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mRv.setLayoutManager(manager);
            adapter = new ImageItemAdapter(R.layout.item_image_lay, images);
            mRv.setAdapter(adapter);
        }

        int ratingNum1 = item.getRatingNum1();
        int ratingNum2 = item.getRatingNum2();
        ratingBar1.setRating(ratingNum1);
        ratingBar2.setRating(ratingNum2);

        helper.addOnClickListener(R.id.pub_ll);
        helper.addOnClickListener(R.id.rating1);
        helper.addOnClickListener(R.id.rating2);
        helper.addOnClickListener(R.id.tv_confirm);

    }
}
