package com.pratamawijaya.instagramlogin.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.pratamawijaya.instagramlogin.R;
import com.pratamawijaya.instagramlogin.utils.InstagramConfig;
import timber.log.Timber;

public class AuthInstagramActivity extends AppCompatActivity {

  private static final String AUTH_URL = "https://api.instagram.com/oauth/authorize/";
  private static final String TOKEN_URL = "https://api.instagram.com/oauth/access_token";

  public interface SignInCallback {
    void onSignIn(String code);
  }

  @Bind(R.id.webview) WebView webView;

  private ProgressDialog progressDialog;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_auth_instagram);
    ButterKnife.bind(this);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    progressDialog = new ProgressDialog(this);
    progressDialog.setMessage("Loading...");

    SignInCallback callback = new SignInCallback() {
      @Override public void onSignIn(String code) {
        Timber.d("data : " + code);
        Intent out = new Intent();
        out.putExtra("code", code);
        setResult(RESULT_OK, out);
        finish();
      }
    };

    webView.setWebViewClient(new SignInWebClient(progressDialog, callback));
    webView.loadUrl(InstagramConfig.INSTA_AUTHORIZATION_URL);
  }

  private static class SignInWebClient extends WebViewClient {
    private ProgressDialog mProgressDialog;
    private SignInCallback callback;

    public SignInWebClient(ProgressDialog mProgressDialog, SignInCallback signInCallback) {
      this.mProgressDialog = mProgressDialog;
      this.callback = signInCallback;
    }

    @Override public void onPageStarted(WebView view, String url, Bitmap favicon) {
      super.onPageStarted(view, url, favicon);
      if (!mProgressDialog.isShowing()) {
        mProgressDialog.show();
      }
    }

    @Override public void onPageFinished(WebView view, String url) {
      super.onPageFinished(view, url);
      if (mProgressDialog.isShowing()) {
        mProgressDialog.dismiss();
      }
    }

    @Override public boolean shouldOverrideUrlLoading(WebView view, String url) {
      if (url.startsWith(InstagramConfig.CALLBACK_URL)) {
        if (mProgressDialog.isShowing()) {
          mProgressDialog.dismiss();
        }
        String[] pair = url.split("code=");
        String accessToken = pair[1];

        Timber.i("access token :" + accessToken);
        if (callback != null) {
          callback.onSignIn(accessToken);
        }
        return true;
      }
      return super.shouldOverrideUrlLoading(view, url);
    }
  }
}
