package com.llc.guowuyuan.com.llc.guowuyuan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.llc.guowuyuan.R;

/**
 * Created by Administrator on 2016/10/25.
 */
public class Fragment_yu extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.yu_layout, container, false);
        return view;
    }
}
