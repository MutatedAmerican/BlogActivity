package android.diazb.blogreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
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
        new BlogWebImage((ImageView) convertView.findViewById(R.id.blogThumbnail))
        .execute(post.thumbnail);

        TextView textView = (TextView) convertView.findViewById(R.id.blogTitle);
        textView.setText(post.title);

        TextView textView1 = (TextView) convertView.findViewById(R.id.blogAuthor);
        textView1.setText(post.author);

        TextView textView2 = (TextView) convertView.findViewById(R.id.blogDate);
        textView2.setText(post.date);


        return convertView;
    }
}