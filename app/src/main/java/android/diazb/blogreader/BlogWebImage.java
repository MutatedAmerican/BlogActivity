package android.diazb.blogreader;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class BlogWebImage extends AsyncTask<String, Void, JSONObject> {
    private ImageView imageview;

    public BlogWebImage(ImageView imageview) {
        this.imageview = imageview;
    }
    @Override
    protected JSONObject doInBackground(String... urls) {
        String urldisplay = urls[0];
        JSONObject bmap = null;

        try{
            URL blogFeedUrl= new URL(urldisplay);

            HttpURLConnection connection=(HttpURLConnection)blogFeedUrl.openConnection();
            connection.connect();

            int responseCode= connection.getResponseCode();

            if (responseCode==HttpURLConnection.HTTP_OK){
                Log.i("BlogPostTask", "Successful Connection" + responseCode);
                bmap=BlogPostParser.get().parse(connection.getInputStream());
            }
        }

        catch (MalformedURLException error) {
            Log.e("BlogPostTask", "Malformed URL:" + error);
        }

        catch (IOException error) {
            Log.e("BlogPostTask", "IO Exception:" + error);
        }

        return bmap;
    }

    protected void onPostExecute(JSONObject jsonObject) {
        BlogPostParser.get().readFeed(jsonObject);

        GridView gridView= (GridView)imageview.findViewById(R.id.GridView);

        BlogPostAdapter adapter= new BlogPostAdapter(imageview, BlogPostParser.get().posts);
        gridView.setAdapter(adapter);
    }
}