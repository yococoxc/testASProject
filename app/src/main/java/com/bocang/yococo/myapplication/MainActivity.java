package com.bocang.yococo.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;





public class MainActivity extends FragmentActivity {

    private FragmentTabHost mainTabHost;
    private LayoutInflater layoutInflater;
    private Class tabFragmentArray[] = {IndexFragment.class, ProductFragment.class, SceneFragment.class, ShopFragment.class, MoreFragment.class};
    private int tabImageArray[] = {R.drawable.main_tab_item_home,R.drawable.main_tab_item_category,R.drawable.main_tab_item_down,R.drawable.main_tab_item_user,R.drawable.main_tab_item_setting};
    private String tabTextArray[] = {"首页","产品","场景","购物车","更多"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("MainActivity","------->>>>onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        layoutInflater = LayoutInflater.from(this);

        mainTabHost = (FragmentTabHost) findViewById(R.id.main_tabhost);
        mainTabHost.setup(this,getSupportFragmentManager(),R.id.readl_main_tab_content);

        int count = tabFragmentArray.length;

        for (int i = 0; i <count; i++) {
            TabHost.TabSpec tabSpec = mainTabHost.newTabSpec(tabTextArray[i]).setIndicator(getTabItemView(i));
            mainTabHost.addTab(tabSpec, tabFragmentArray[i], null);
            mainTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.main_tab_item_bg);
        }
    }


    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.tab_item_imageview);
        imageView.setImageResource(tabImageArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.tab_item_textview);
        textView.setText(tabTextArray[index]);

        return view;
    }
}
