package com.example.fpe.myapplication;

import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_fullscreen);

        WebView webview = (WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

        if (Build.VERSION.SDK_INT >= 19) {
            webview.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {
            webview.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        final Activity activity = this;
        webview.loadUrl("https://laruchequiditoui.fr/fr/");
    }
}
