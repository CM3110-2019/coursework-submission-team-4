
package com.example.parkingprogram;

import android.content.SharedPreferences;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SharedPrefsActivity extends AppCompatActivity{

    private static final String TAG = SharedPrefsActivity.class.getCanonicalName();

    private List<HandleXML> favourites;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor mEditor;

    private RecyclerView recyclerView;
    private FavouritesRecyclerViewAdapter adapter;

    private RecyclerView favouriteCarpark;
    private Button selectFavourite;

    private HandleXML parser;
    private String xmlURL = "http://www.leedstravel.info/datex2/carparks/content.xml";


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
        mEditor.apply();

        sharedPreferences.getString("key", "");
        Log.d(TAG, "onCreate: name: " + "");


        recyclerView = findViewById(R.id.selectFavouritePark);
        adapter = new FavouritesRecyclerViewAdapter(getApplicationContext(), favourites);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        downloadCarParks();

        checkSharedPreferences();

        final boolean[] clicked = {false};
        selectFavourite.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(clicked[0] = true){
                    mEditor.putString(getString(R.string.selectFavouritePark), "");
                    mEditor.commit();
                }
            }
        });

    }

    private void downloadCarParks() {

        parser = new HandleXML(xmlURL);
        Log.d("sam", "Before fetchXML");
        parser.fetchXML();
        while (parser.parsingComplete) ;
        //Testing
        Log.d("name", parser.getCarParkIdentity());
        Log.d("occupancy", parser.getCarParkOccupancy());
        Log.d("spaces taken", parser.getOccupiedSpaces());
        Log.d("capacity", parser.getTotalCapacity());


    }

        private void checkSharedPreferences(){
            String favouritePark = sharedPreferences.getString(getString(R.string.selectFavouritePark), "");


        }
    }



