package com.hanchao.summary.drawer;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanchao.summary.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerHomeFragment extends Fragment {


    public DrawerHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drawer_home, container, false);
    }

}
