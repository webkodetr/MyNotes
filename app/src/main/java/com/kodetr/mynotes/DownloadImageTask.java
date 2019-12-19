package com.kodetr.mynotes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    ImageView bmImage;

    public DownloadImageTask(ImageView bmImage){this.bmImage = bmImage;}
    protected Bitmap doInBackground(String... urls){
        String urldisplay = urls[0];
        Bitmap mIcon= null;

        try{
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon = BitmapFactory.decodeStream(in);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mIcon;
    }
    @Override
    protected void onPostExecute(Bitmap bitmap){
        super.onPostExecute(bitmap);
        bmImage.setImageBitmap(bitmap);
    }
}
