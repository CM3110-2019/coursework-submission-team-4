package com.example.parkingprogram;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Main5Activity extends AppCompatActivity {

    private Button btnfind;
    private String url1 ="http://www.leedstravel.info/datex2/carparks/content.xml";
    private String url2 ="&mode=xml";
    private HandleXML parser;
    private SearchView searchbtn;
    private Button logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        searchbtn = (SearchView) findViewById(R.id.searchbtn);
        btnfind = (Button) findViewById(R.id.btnFind);
        logout = (Button) findViewById(R.id.btnLogout);

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        parser = new HandleXML(url1);
        parser.fetchXML();
        while (parser.parsingComplete) ;
        Log.d("xmltest", parser.getCarParkIdentity());


        //GOOGLE API

        }



    }
