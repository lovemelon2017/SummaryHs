package com.hanchao.summary.xpop;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.hanchao.summary.R;
import com.lxj.xpopup.XPopup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XpopImageActivity extends AppCompatActivity {
    String url1 = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1953341652,495424083&fm=26&gp=0.jpg";
    String url2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1591877192539&di=26b9a866482376fca3fa839c95921e5d&imgtype=0&src=http%3A%2F%2Fpic.feizl.com%2Fupload%2Fallimg%2F170615%2F1TH010Z-7.jpg";
    public static ArrayList<Object> list = new ArrayList<>();

    @BindView(R.id.rv_rv)
    RecyclerView mRv;
    ImageAdapter mAdapter;

    @BindView(R.id.image1)
    ImageView iv1;
    @BindView(R.id.image2)
    ImageView iv2;

    static {
        list.clear();
        list.add("https://img.zcool.cn/community/011ad05e27a173a801216518a5c505.jpg");
        list.add("https://img.zcool.cn/community/0148fc5e27a173a8012165184aad81.jpg");
        list.add("https://img.zcool.cn/community/013c7d5e27a174a80121651816e521.jpg");
        list.add("https://img.zcool.cn/community/01b8ac5e27a173a80120a895be4d85.jpg");
        list.add("https://img.zcool.cn/community/01a85d5e27a174a80120a895111b2c.jpg");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xpop_image);
        ButterKnife.bind(this);
        initRv();
        Glide.with(this).load(url1).apply(new RequestOptions().override(Target.SIZE_ORIGINAL).transform(new RoundedCorners(10))).into(iv1);
        Glide.with(this).load(url2).into(iv2);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new XPopup.Builder(XpopImageActivity.this)
                        .asImageViewer(iv1, url1, true, -1, -1, 10, false, new ImageLoader())
                        .show();
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new XPopup.Builder(XpopImageActivity.this)
                        .asImageViewer(iv2, url2, new ImageLoader())
                        .show();
            }
        });


    }

    private void initRv() {
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        mRv.setLayoutManager(manager);
        mAdapter = new ImageAdapter(R.layout.item_image_pop, list);
        mRv.setAdapter(mAdapter);
    }
}
