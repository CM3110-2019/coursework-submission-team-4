package com.example.parkingprogram;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.parkingprogram.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ApiActivity extends FragmentActivity implements OnMapReadyCallback{

    GoogleMap map;


    protected void OnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;

        LatLng Aberdeen = new LatLng(57.245775, -2.499710);
        map.addMarker(new MarkerOptions().position(Aberdeen).title("Aberdeen"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Aberdeen));

    }

}
