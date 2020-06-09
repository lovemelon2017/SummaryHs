package com.hanchao.summary.multiple;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * lovely_melon
 * 2020/5/9
 */
public class CustomMultiBean implements MultiItemEntity {

    public static final int TYPE_TEXT = 1;
    public static final int TYPE_ADVERT = 2;
    int customType;

    public int getCustomType() {
        return customType;
    }

    public void setCustomType(int customType) {
        this.customType = customType;
    }

    @Override
    public int getItemType() {
        return customType;
    }
}
