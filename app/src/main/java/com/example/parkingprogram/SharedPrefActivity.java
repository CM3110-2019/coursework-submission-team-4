package com.example.parkingprogram;

import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.widget.Toast;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SharedPrefsActivity extends AppCompatActivity{

    private static final String TAG = SharedPrefsActivity.class.getCanonicalName();

    private List<Location> favourites;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor mEditor;

    private RecyclerView recyclerView;
    private FavouritesRecyclerViewAdapter adapter;

    private RecyclerView favouriteCarpark;
    private Button selectFavourite;

    private HandleXML parser;
    String url = "http://www.leedstravel.info/datex2/carparks/content.xml";

    public String setFavourites() {
        setFavourites();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        Set<String> selectedFavouriteIds = sharedPreferences.getStringSet(getString(R.string.shared_pref_defaultFavourite), new HashSet<String>());

        favouriteCarpark = (RecyclerView) findViewById(R.id.selectFavouritePark);
        selectFavourite = (Button) findViewById(R.id.button8);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.sharedPreferences = getSharedPreferences(getString(R.string.shared_pref_defaultFavourite), MODE_PRIVATE);

        mEditor.putStringSet(getString(R.string.shared_pref_defaultFavourite), selectedFavouriteIds);
        mEditor = sharedPreferences.edit();

        sharedPreferences.getString("key", "");
        Log.d(TAG, "onCreate: name: " + "");


        recyclerView = findViewById(R.id.selectFavouritePark);
        adapter = new FavouritesRecyclerViewAdapter(getApplicationContext(), favourites);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        downloadCarParks();

    }

    private void downloadCarParks() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            public void onResponse(String response) {
                parser = new HandleXML(url);
                parser.fetchXML(response);
                while (parser.parsingComplete) ;
                //Testing
                Log.d("xmltest", parser.getCarParkIdentity());

                adapter.setFavourites(favourites);
            }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i(TAG, "error " + error.getLocalizedMessage());
                    Toast.makeText(getApplicationContext(), getString(R.string.error_downloading_locations), Toast.LENGTH_LONG);

                }
            });
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
             queue.add(stringRequest);
        }
    }


