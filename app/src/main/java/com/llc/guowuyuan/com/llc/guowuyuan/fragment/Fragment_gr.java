package com.llc.guowuyuan.com.llc.guowuyuan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.llc.guowuyuan.R;


public class Fragment_gr extends Fragment {

    private GridView gr;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item1, container, false);
        gr= (GridView) v.findViewById(R.id.gr);
        init();
        return v;
    }

    private void init() {
        gr.setAdapter(new BaseAdapter() {
                @Override
                public int getCount() {
                    return 30;
                }

                @Override
                public Object getItem(int i) {
                    return null;
                }

                @Override
                public long getItemId(int i) {
                    return 0;
                }

                @Override
                public View getView(int i, View view, ViewGroup viewGroup) {
                    View v=View.inflate(getActivity(),R.layout.gr_item,null);
                    ImageView iv= (ImageView) v.findViewById(R.id.iv_tou);
                    TextView tv_name= (TextView) v.findViewById(R.id.tv_name);
                    return v;
                }
            });
    }
}
