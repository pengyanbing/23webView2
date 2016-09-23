package com.example.administrator.a23webview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public WebView webView;
    private String contex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = ((WebView) findViewById(R.id.webView));
        webView.loadData(getcontex(), "text/html;charset=utf-8", "utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
    }

    public String getcontex() {
        StringBuffer result = new StringBuffer();
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(getAssets().open("html.txt")));
            String str;
            while ((str = br.readLine()) != null) {
                result.append(str);
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
