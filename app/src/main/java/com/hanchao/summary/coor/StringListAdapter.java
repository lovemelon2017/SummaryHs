package com.hanchao.summary.coor;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hanchao.summary.rvandrv.ImageItemAdapter;

public class StringListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    RecyclerView mRv;
    ImageItemAdapter adapter;

    public StringListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {


    }
}
