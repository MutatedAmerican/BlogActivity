package android.diazb.blogreader;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class BlogWebImage extends AsyncTask<String, Void, Bitmap> {
    ImageView imageview;

    public BlogWebImage(ImageView imageview) {
        this.imageview = imageview;
    }
    @Override
    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap bitmap = null;

        try{
            URL blogFeedUrl= new URL(url);

            HttpURLConnection connection=(HttpURLConnection)blogFeedUrl.openConnection();
            connection.connect();

            int responseCode= connection.getResponseCode();

            if (responseCode==HttpURLConnection.HTTP_OK){
                Log.i("BlogWebImage", "Successful Connection" + responseCode);
                InputStream in = new java.net.URL(url).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            }
        }

        catch (MalformedURLException error) {
            Log.e("BlogWebImage", "Malformed URL:" + error);
        }

        catch (IOException error) {
            Log.e("BlogWebImage", "IO Exception:" + error);
        }
        return bitmap;
    }

    protected void onPostExecute(Bitmap display) {
        imageview.setImageBitmap(display);
    }
}