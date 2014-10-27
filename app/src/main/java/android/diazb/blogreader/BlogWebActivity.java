package android.diazb.blogreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class BlogWebActivity extends Activity{

    protected ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_web);

        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        WebView webView= (WebView)findViewById(R.id.webView);

        progressBar.setVisibility(View.GONE);

        Intent intent= getIntent();
        Uri blogUri= intent.getData();

        webView.loadUrl(blogUri.toString());
    }
}
