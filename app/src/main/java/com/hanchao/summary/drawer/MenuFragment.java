package com.hanchao.summary.drawer;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.hanchao.summary.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    TextView tvTab1;
    TextView tvTab2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_menu, container, false);
        tvTab1 = inflate.findViewById(R.id.drawer_item_tv1);
        tvTab2 = inflate.findViewById(R.id.drawer_item_tv2);

        tvTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlidingRightActivity activity = (SlidingRightActivity) getActivity();
                activity.replaceFragment(new Tab1Fragment());
            }
        });
        tvTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlidingRightActivity activity = (SlidingRightActivity) getActivity();
                activity.replaceFragment(new Tab2Fragment());
            }
        });
        return inflate;
    }


}
