package com.hanchao.summary.multiple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hanchao.summary.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MultipleActivity extends AppCompatActivity {
    @BindView(R.id.multi_rv)
    RecyclerView mRv;

    MultipleAdapter mAdapter;

    List<CustomMultiBean> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple);
        ButterKnife.bind(this);

        initRv();


        //模拟数据请求
        loadData();

    }

    private void loadData() {
        List<CustomMultiBean> beanList = new ArrayList<>();
        CustomMultiBean bean1 = new CustomMultiBean();
        bean1.setCustomType(1);
        beanList.add(bean1);

        CustomMultiBean bean2 = new CustomMultiBean();
        bean2.setCustomType(2);
        beanList.add(bean2);

        CustomMultiBean bean3 = new CustomMultiBean();
        bean3.setCustomType(2);
        beanList.add(bean3);

        CustomMultiBean bean4 = new CustomMultiBean();
        bean4.setCustomType(1);
        beanList.add(bean4);

        datas.addAll(beanList);
        mAdapter.setNewData(datas);
    }

    private void initRv() {
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MultipleAdapter(datas);
        mRv.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShort("您点击了Item位置: " + position);
            }
        });

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.item_advert_iv1:
                        ToastUtils.showShort("您点击了:橙色");
                        break;
                    case R.id.item_advert_iv2:
                        ToastUtils.showShort("您点击了:灰色");
                        break;
                    case R.id.item_advert_iv3:
                        ToastUtils.showShort("您点击了:蓝色");
                        break;
                }
            }
        });
    }
}
