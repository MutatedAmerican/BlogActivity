package android.diazb.blogreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BlogPostAdapter extends ArrayAdapter<BlogPost> {

    public BlogPostAdapter(Context context, ArrayList<BlogPost> posts) {
        super(context, 0, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BlogPost post= getItem(position);

        if(convertView== null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.activity_layout, parent, false);
        }

        TextView textViewtitle= (TextView)convertView.findViewById(android.R.id.text1);
        textViewtitle.setText(post.title);

        TextView textViewauthor= (TextView)convertView.findViewById(android.R.id.text1);
        textViewauthor.setText(post.author);

        return convertView;
    }
}
