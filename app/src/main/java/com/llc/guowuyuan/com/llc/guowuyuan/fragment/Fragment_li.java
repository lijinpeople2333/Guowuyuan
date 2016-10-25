package com.llc.guowuyuan.com.llc.guowuyuan.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.llc.guowuyuan.R;
import com.llc.guowuyuan.com.llc.guowuyuan.fragment.adapter.MyListAdapter;
import com.llc.guowuyuan.com.llc.guowuyuan.fragment.utils.HttpUtils;
import com.llc.guowuyuan.com.llc.guowuyuan.fragment.vo.BeanData;
import com.llc.guowuyuan.com.llc.guowuyuan.fragment.vo.CommunityBean;

import java.util.List;

public class Fragment_li extends Fragment {

    private boolean isViewCreated;
    private boolean isLoadDataCompleted;

    private ListView listView;
    private View v;
    private String path = "http://open.qyer.com/qyer/bbs/entry?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.item2, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化控件
        initView();

    }

    private void initView() {
        listView = (ListView) v.findViewById(R.id.list);
        isViewCreated = true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser && isViewCreated)//只有在用户可见以及初始化之后才加载数据
        {
            lazyLoad();
        }
    }

    private void lazyLoad() {
        if (!isLoadDataCompleted) {
            initView();
            initData();
            isLoadDataCompleted = true;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isLoadDataCompleted = false;//这里需要重置状态，不然加载了之后就没办法再重新加载了
    }

    private void initData() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String str = HttpUtils.Getstr(path);
                return str;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                Gson gson = new Gson();
                BeanData bean = gson.fromJson(s, BeanData.class);
                List<BeanData.DataEntity.ForumListEntity.GroupEntity> list = bean.getData().getForum_list().get(0).getGroup();

                //适配器
                listView.setAdapter(new MyListAdapter(getContext(), list));

            }
        }.execute();
    }
}
