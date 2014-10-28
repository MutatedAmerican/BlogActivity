package android.diazb.blogreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class BlogWebActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_web);

        Intent intent= getIntent();
        Uri blogUri= intent.getData();

        final ProgressBar progressbar= (ProgressBar)findViewById(R.id.ProgressBarWeb);

        WebView webView= (WebView)findViewById(R.id.webView);
        webView.loadUrl(blogUri.toString());

        webView.setWebViewClient(new WebViewClient() {
           @Override
            public void onPageFinished(WebView webview, String url) {

               progressbar.setVisibility(View.GONE);
            }
        });
    }
}
