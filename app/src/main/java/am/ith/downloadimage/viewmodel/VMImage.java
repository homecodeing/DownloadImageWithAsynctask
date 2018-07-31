package am.ith.downloadimage.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.io.InputStream;

import am.ith.downloadimage.AppConstants;

public class VMImage extends ViewModel {
    private MutableLiveData<Bitmap> modelMutableLiveData;
    Activity activity;
    Context context;
    ProgressDialog mProgressDialog;
    public VMImage() {
        activity= (Activity) context;
        // Execute DownloadImage AsyncTask
        new DownloadImage().execute(AppConstants.IMAGE_URL);
    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(activity);
            // Set progressdialog title
            mProgressDialog.setTitle("Download Image Tutorial");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {
                // Download Image from URL
                InputStream input = new java.net.URL(imageURL).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Set the bitmap into ImageView
            if (result!=null){
                Toast.makeText(activity, "OKKK", Toast.LENGTH_SHORT).show();
            }
            // Close progressdialog
            mProgressDialog.dismiss();
        }
    }
}
