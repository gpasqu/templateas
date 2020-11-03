package com.example.foufoudesrie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ListView listview;
    SerieAdapter mAdapter;
    ArrayList<Serie> lesSeries=new ArrayList<Serie>();
        @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(MainActivity.this));
            JSONArray userArray = obj.getJSONArray("data");
            for (int i = 0; i < userArray.length(); i++) {
                JSONObject userDetail = userArray.getJSONObject(i);


                Serie a = new Serie(userDetail.getInt("id"),userDetail.getString("titre") ,userDetail.getString(("resume")),userDetail.getString("duree") , userDetail.getString("premiereDiffusion"),userDetail.getString("image"));

                lesSeries.add(a);
            }
             listview = (ListView) findViewById(R.id.lstView);
             mAdapter = new SerieAdapter(MainActivity.this,lesSeries);
             listview.setAdapter(mAdapter);
             double test =0.0;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        }

    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            context.getAssets();
            InputStream is = context.getAssets().open("serie.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


}