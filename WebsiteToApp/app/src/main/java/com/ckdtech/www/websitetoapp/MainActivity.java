package com.ckdtech.www.websitetoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity{

            private WebView webView;

            @Override
              public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
        	        setContentView(R.layout.activity_main);

        	        //init the webview
        	        webView = (WebView) findViewById(R.id.webView);
        	        //get web settings
        	        WebSettings webSettings = webView.getSettings();
        	        //set this for javascript containing sites
              webSettings.setJavaScriptEnabled(true);
                //load your url
        	        //paste the full url here as appears in the address bar in a browser
        	        webView.loadUrl("https://www.tutorialspoint.com/");
        	        //for opening links inside app
        	        webView.setWebViewClient(new WebViewClient());
        	    }

        	    //if you are on a different page then backbutton won't finish the app with this code
        	    @Override
    public void onBackPressed() {
                if (webView.canGoBack()) {
            	            webView.goBack();
            	        } else {
            	            super.onBackPressed();
            	        }
        	    }
	}
