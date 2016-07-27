package com.bocang.yococo.myapplication;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment implements AdapterView.OnItemClickListener {


    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);


//        LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.listview_content);
//        linearLayout.addView();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),R.array.moreLists,android.R.layout.simple_expandable_list_item_1);

        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0: {
                //公司简介
                Intent intent = new Intent(getActivity(), CompanyIntroActivity.class);
                startActivity(intent);
            } break;
            case 1: {
                //登录官网
//                Intent intent = new Intent(getActivity(), OfficialWebsiteActivity.class);
//                startActivity(intent);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);

            } break;
            case 2: {
                //一键联系
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel://10086"));
                startActivity(intent);
            } break;
            case 3: {
                //清理缓存
            } break;
            case 4: {
                //用户指南
            } break;
            case 5: {
                //一键分享
            } break;
            case 6: {
                //经销商管理
            } break;
        }
    }
}
