package com.hanchao.summary.xpop;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hanchao.summary.R;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.interfaces.OnSrcViewUpdateListener;

import java.util.List;

public class ImageAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {
    public ImageAdapter(int layoutResId, @Nullable List<Object> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Object item) {
        int position = helper.getAbsoluteAdapterPosition();
        List<Object> data = getData();

        Glide.with(mContext).load(item).apply(new RequestOptions().placeholder(R.drawable.no_banner)
                .override(Target.SIZE_ORIGINAL))
                .into((ImageView) helper.getView(R.id.item_iv));
        ImageView imageView = helper.getView(R.id.item_iv);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new XPopup.Builder(mContext).asImageViewer(imageView, position, data, new OnSrcViewUpdateListener() {
                    @Override
                    public void onSrcViewUpdate(ImageViewerPopupView popupView, int position) {
                        popupView.updateSrcView(imageView);
                    }
                }, new ImageLoader())
                        .show();
            }
        });
    }
}
