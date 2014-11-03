package android.diazb.blogreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class BlogPostAdapter extends ArrayAdapter<BlogPost> {

    public BlogPostAdapter(Context context, ArrayList<BlogPost> posts) {
        super(context, 0, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BlogPost post = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_layout, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.blogTitle);
        textView.setText(post.title);

        TextView textView1 = (TextView) convertView.findViewById(R.id.blogAuthor);
        textView1.setText(post.author);

        TextView textView2 = (TextView) convertView.findViewById(R.id.blogDate);
        textView2.setText(post.date);

        class ImageView extends AsyncTask<String, Void, Bitmap> {
            ImageView imageview;
            URLConnection connection;
            JSONObject jsonObject = null;


            public ImageView(ImageView imageview) {
                this.imageview = imageview;
            }

            protected Bitmap doInBackground(String... urls) {
                String url = urls[0];
                Bitmap bitmap = null;
                try {
                    Log.i("BlogPostTask", "Successful Connection" + responseCode);
                    JSONObject jsonObject = BlogPostParser.get().parse(connection.getInputStream());
                }
                catch (Exception e) {
                    Log.e("Error", e.getMessage());
                    e.printStackTrace();
                }
                return bitmap;
            }
        }
        ImageView imageview = (ImageView)convertView.findViewById(R.id.blogThumbnail);
        imageview.setImageBitmap(thumbnail);
    }