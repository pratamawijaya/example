package com.pratamawijaya.exampleinstagram.authentication;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.pratamawijaya.exampleinstagram.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class InstagramWebviewAuthActivity extends ActionBarActivity {

    @InjectView(R.id.webview)
    WebView webView;

    private OAUTHWebviewListener listener;
    private String URL = "";
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_webview_auth);
        ButterKnife.inject(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        webView.setWebViewClient(new WebClient());
        webView.loadUrl(URL);
    }


    private class WebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith(InstagramApp.CALLBACKURL)) {
                String[] data = url.split("=");
                listener.onComplete(data[1]);
                return true;
            }
            return false;
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            listener.onError(description);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressDialog.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressDialog.dismiss();
        }
    }

    public interface OAUTHWebviewListener {
        public abstract void onComplete(String accessToken);

        public abstract void onError(String error);
    }

}
