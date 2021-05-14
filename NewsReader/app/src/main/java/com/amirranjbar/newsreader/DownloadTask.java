package com.amirranjbar.newsreader;

import android.os.AsyncTask;
import android.provider.Telephony;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {
        String result = "";
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            int data = inputStreamReader.read();
            while (data != -1) {
                char current = (char) data;
                result += current;
                data = inputStreamReader.read();
            }
            JSONObject jsonObject = new JSONObject(result);
            String serviceData = jsonObject.getString("data");
            return serviceData;
        } catch (Exception ex) {
            String exMessage = "doInBackground : " + String.valueOf(ex);
            Log.i("DebugException ", exMessage);
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //MainActivity mainActivity= new MainActivity();
        //mainActivity.updateListView();
    }
}
