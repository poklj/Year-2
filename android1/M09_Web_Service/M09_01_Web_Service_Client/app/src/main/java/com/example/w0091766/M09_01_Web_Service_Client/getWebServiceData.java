package com.example.w0091766.M09_01_Web_Service_Client;

import android.graphics.Color;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;


/**
 * Created by Russ on 2/28/2016.
 */
public class getWebServiceData extends Thread {

    String content = null;

    // delegate setup to return ball to caller
    public getResponse delegate = null;
    Ball b = null;

    @Override
    public void run() {

        // loop getting Web Service data
        while (true) {

            URL url = null;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL("http://172.16.176.115:8084/RestWithTomCat/webresources/getAnimal");
                urlConnection = (HttpURLConnection) url.openConnection();

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");

                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                content = br.readLine();  // get the JSON string in one read
                System.out.println("content: " + content);

                conn.disconnect();

                /////////////////////////////////////////
                // Make Network Animal from json string
                try {
                    JSONObject getAnimal = new JSONObject(content);
                    int x = getAnimal.getInt("pos_x");
                    int y = getAnimal.getInt("pos_y");
                    int dx = getAnimal.getInt("vel_x");
                    int dy = getAnimal.getInt("vel_y");
                    System.out.println("Output vals: x=" + x + " y=" + y + " dx=" + dx + " dy=" + dy);

                    b = new Ball(Color.DKGRAY, (float) x, (float) y, (float) dx, (float) dy);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // bottom of While... give response
            delegate.getBallResponse(b);

            // Wait a few seconds...
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
