package com.findide.hybird;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class HybirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hybird);

        //init parameter
        // 获取传递过来的信息。
        String urlParam = getIntent().getStringExtra("url");
        if(urlParam==null || urlParam.equals("") )
            urlParam="file:///android_asset/index.html";

        WebView mWeb = (WebView)findViewById(R.id.main_web);
        mWeb.getSettings().setJavaScriptEnabled(true);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        mWeb.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        mWeb.addJavascriptInterface(new JSBridge(), "android");
        mWeb.loadUrl(urlParam);//http://photoswipe.com/ file:///android_asset/index.html

        WebSettings webSettings = mWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);//关键点

    }

    public class JSBridge{
        @JavascriptInterface
        public String toast(String str) {

            /* //js调用
        var param = "我是传入的参数";
var result = android.toast(param);
console.log(result);
         */
            Toast.makeText(getApplicationContext(), "传入的参数是" + str, Toast.LENGTH_SHORT).show();
            return "我是android信息";
        }
    }
}
