package android.diazb.blogreader;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONObject;
import java.net.URLConnection;

public class BlogWebImage {
    public final String thumbnail;
}

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
                Log.i("BlogPostTask", "Successful Connection" + url);
                JSONObject jsonObject = BlogPostParser.get().parse(connection.getInputStream());
            }
            catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bitmap;
        }
    }


    public BlogWebImage(String thumbnail){
        this.thumbnail=thumbnail;
    }