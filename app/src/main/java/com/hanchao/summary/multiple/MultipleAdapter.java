package com.hanchao.summary.multiple;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hanchao.summary.R;

import java.util.List;

/**
 * lovely_melon
 * 2020/5/9
 */
public class MultipleAdapter extends BaseMultiItemQuickAdapter<CustomMultiBean, BaseViewHolder> {


    public MultipleAdapter(List<CustomMultiBean> data) {
        super(data);
        addItemType(CustomMultiBean.TYPE_TEXT, R.layout.item_multi_text);
        addItemType(CustomMultiBean.TYPE_ADVERT, R.layout.item_multi_advert);
    }

    @Override
    protected void convert(BaseViewHolder helper, CustomMultiBean item) {
        int adapterPosition = helper.getBindingAdapterPosition();


        helper.addOnClickListener(R.id.item_advert_iv1);
        helper.addOnClickListener(R.id.item_advert_iv2);
        helper.addOnClickListener(R.id.item_advert_iv3);

    }
}
