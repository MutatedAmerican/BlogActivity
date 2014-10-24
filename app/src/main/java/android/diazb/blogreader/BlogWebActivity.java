package android.diazb.blogreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class BlogWebActivity extends Activity{

    protected ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_web);

        progressBar=(ProgressBar)findViewById(R.id.ProgressBar);

        Intent intent= getIntent();
        Uri blogUri= intent.getData();

        WebView webView= (WebView)findViewById(R.id.webView);
        //WebView.setEmptyView(progressBar);
        webView.loadUrl(blogUri.toString());
    }
}
