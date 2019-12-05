package com.example.parkingprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FavouritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        recyclerView = findViewById(R.id.);
        FavouritesRecyclerViewAdapter adapter = new FavouritesRecyclerViewAdapter(getApplicationContext, favourites);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinerLayoutManager(getApplicationContext()));

    }
}
