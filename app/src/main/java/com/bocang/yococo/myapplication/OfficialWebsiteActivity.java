package com.bocang.yococo.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class OfficialWebsiteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_official_website);

        WebView webview = (WebView) findViewById(R.id.webView);
        webview.loadUrl("http://www.baidu.com");

    }
}
