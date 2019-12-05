package com.example.parkingprogram;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class SharedPrefActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    private SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        //initiate sharedPrefs
        this.sharedPrefs = getSharedPreferences(getString(R.string.shared_prefs_filename), MODE_PRIVATE);


        //set all the favourite car parks with ids that are strings in the shared preferences string set
        Set<String> selectedFavouritesIds = sharedPrefs.getStringSet(getString(R.string.shared_pref_filename), new HashSet<String>());
        for (Favourite favourite : favourites) {
            if (selectedFavouritesIds.equals(favourites.getId())){
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
        for (Favourite favourite: this.favourites) {
            if (favourite.isSelected()){
                selectedFavouriteIds.add(favourite.getId());
            }
        }
        sharedPrefsEditor.putStringSet(R.string.shared_pref_filename), selectedFavouriteIds);

        //apply changes
        sharedPrefsEditor.apply();
    }
}
