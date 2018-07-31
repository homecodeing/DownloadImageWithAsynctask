package am.ith.downloadimage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;

public class LoginBusinessTask extends AsyncTask<String,Void,Bitmap> {
    private Context context;
    private String method;
    private Activity activity;
    private String URL_REQUEST="http://jaydeep.betainfotech.com/AFBUSINESS_DIRECTORY/public/api/login";

    private ProgressDialog progressDialog;
    private AlertDialog.Builder builderAlertDialog;

    public LoginBusinessTask(Context context) {
        this.context = context;
        activity=(Activity)context;
    }
    @Override
    protected Bitmap doInBackground(String... strings) {

        return null;
    }

    @Override
    protected void onPostExecute(Bitmap json) {
        progressDialog.dismiss();

    }

    @Override
    protected void onPreExecute() {
        builderAlertDialog=new AlertDialog.Builder(activity);
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Please Wait...");
        progressDialog.setMessage("Connecting to Server...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
    public void showDialog(String title,String message,String code){
        builderAlertDialog.setTitle(message);
        AlertDialog alertDialog=builderAlertDialog.create();
        alertDialog.show();
    }
}
