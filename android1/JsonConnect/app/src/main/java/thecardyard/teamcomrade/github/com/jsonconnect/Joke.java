package thecardyard.teamcomrade.github.com.jsonconnect;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Joke  extends AsyncTask {

    private static String jokeAPI_random = "https://api.icndb.com/jokes/random";
    StringBuilder stringBuilder = new StringBuilder();
    private URL url;
    TextView tv;
    private String result;
    public Joke(TextView tv){
        this.tv = tv;
    }
    @Override
    protected void onPreExecute(){
        try {
            this.url = new URL(jokeAPI_random);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        try{
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            JSONObject jsonMain ;
            jsonMain = new JSONObject(stringBuilder.toString());
            Log.d("Json", jsonMain.toString());
            JSONObject jsonData = new JSONObject(jsonMain.get("value").toString());
            Log.d("Json", jsonData.toString());
            this.result = jsonData.get("joke").toString();
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        Log.d("Json", result);
        tv.setText(result);
    }

    protected String getJoke(){
        return result;
    }
}
