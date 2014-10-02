package android.diazb.blogreader;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class BlogPostTask extends AsyncTask<Activity, Void, JSONObject>{
    @Override
    protected JSONObject doInBackground(Activity... params) {

        try{
            URL blogFeedUrl= new URL("http://blog.teamtreehouse.com/api/get_recent_summary/?count10");
        }

        catch (MalformedURLException error) {
            Log.e("BlogPostTask", "Malformed URL:" + error);
        }
        return null;
    }
}
