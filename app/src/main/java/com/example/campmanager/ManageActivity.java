package com.example.campmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ManageActivity extends AppCompatActivity {
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        //getActionBar().hide();
        wv=findViewById(R.id.webview);
        wv.setWebChromeClient(new WebChromeClient());
        wv.loadUrl("https://console.firebase.google.com/u/1/");

    }

    @Override
    public void onBackPressed() {
        if(wv.canGoBack()){
            wv.goBack();
        }
        else
        super.onBackPressed();
    }
}
