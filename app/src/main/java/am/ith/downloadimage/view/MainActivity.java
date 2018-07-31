package am.ith.downloadimage.view;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

import am.ith.downloadimage.AppConstants;
import am.ith.downloadimage.LoginBusinessTask;
import am.ith.downloadimage.R;
import am.ith.downloadimage.viewmodel.VMImage;

public class MainActivity extends AppCompatActivity {
    ProgressDialog mProgressDialog;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageID);
        // Execute DownloadImage AsyncTask
//        new DownloadImage().execute(AppConstants.IMAGE_URL);
        new LoginBusinessTask(this).execute(AppConstants.IMAGE_URL);
    }
//    // DownloadImage AsyncTask
//    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            // Create a progressdialog
//            mProgressDialog = new ProgressDialog(MainActivity.this);
//            // Set progressdialog title
//            mProgressDialog.setTitle("Download Image Tutorial");
//            // Set progressdialog message
//            mProgressDialog.setMessage("Loading...");
//            mProgressDialog.setIndeterminate(false);
//            // Show progressdialog
//            mProgressDialog.show();
//        }
//
//        @Override
//        protected Bitmap doInBackground(String... URL) {
//
//            String imageURL = URL[0];
//
//            Bitmap bitmap = null;
//            try {
//                // Download Image from URL
//                InputStream input = new java.net.URL(imageURL).openStream();
//                // Decode Bitmap
//                bitmap = BitmapFactory.decodeStream(input);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return bitmap;
//        }
//
//        @Override
//        protected void onPostExecute(Bitmap result) {
//            // Set the bitmap into ImageView
//            if (result!=null){
//               imageView.setImageBitmap(result);
//            }
//            // Close progressdialog
//            mProgressDialog.dismiss();
//        }
//    }
}
