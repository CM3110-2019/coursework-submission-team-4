package com.example.parkingprogram;

import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;


import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SharedPrefActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    private SharedPreferences sharedPrefs;
    private List<Location>  favourites;
    private String favourite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //initiate sharedPrefs
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        this.sharedPrefs = getSharedPreferences(getString(R.string.shared_pref_defaultFavourite), MODE_PRIVATE);


        //set all the favourite car parks with ids that are strings in the shared preferences string set
        Set<String> selectedFavouritesIds = sharedPrefs.getStringSet(getString(R.string.shared_pref_defaultFavourite), new HashSet<String>());
        for (Location favourite : favourites) {
            if (selectedFavouritesIds.equals(favourites.getId())) {
                favourite.setSelected(true);
                break;
            }
        }

    }

    @Override
    protected void onPause() {


        super.onPause();
        SharedPreferences.Editor sharedPrefsEditor = this.sharedPrefs.edit();


        Set<String> selectedFavouriteIds = new HashSet <String>();

        //store favourite car park that has been selected
        for (Location favourite: this.favourites) {
            if (favourite.isSelected()){
                selectedFavouriteIds.add(favourite.getId());
            }
        }
        sharedPrefsEditor.putStringSet(getString(R.string.shared_pref_defaultFavourite), selectedFavouriteIds);

        //apply changes
        sharedPrefsEditor.apply();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
