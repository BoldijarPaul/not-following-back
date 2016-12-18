package com.bolnizar.notfollowingback.login;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.bolnizar.notfollowingback.R;
import com.bolnizar.notfollowingback.utils.Constants;

/**
 * Created by Musafir on 12/18/2016.
 */

public class LoginWebDialogFragment extends DialogFragment {

    private WebView mWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mWebView = (WebView) inflater.inflate(R.layout.fragment_login_web_dialog, container, false);
        return mWebView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initializeWebClient();
    }

    private void initializeWebClient() {
        mWebView.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                final Uri uri = Uri.parse(url);
                return handleUri(uri);
            }

            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                final Uri uri = request.getUrl();
                return handleUri(uri);
            }

            private boolean handleUri(Uri uri) {
                String url = uri.toString();
                if (url.startsWith(Constants.REDIRECT_URL)) {
                    String accessToken = url.split("#access_token=")[1];
                    Toast.makeText(getContext(), accessToken, Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
}
