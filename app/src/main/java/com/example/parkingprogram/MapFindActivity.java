package com.example.parkingprogram;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFindActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {
    //Creating fields
    private Button btnfind;
    private HandleXML parser;
    private SearchView searchbtn;
    private Button logout;
    private Object mMapFragment1;

    //Getting the API
    private String url1 = "http://www.leedstravel.info/datex2/carparks/content.xml";
    private String url2 = "&mode=xml";

    //Google map field
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btnfind = (Button) findViewById(R.id.btnFind);
        btnfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCarParkInfo();
            }
        });

        //Getting and finding the fragment(map)
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Viewing by ids
        searchbtn = (SearchView) findViewById(R.id.searchbtn);
        btnfind = (Button) findViewById(R.id.btnFind);
        logout = (Button) findViewById(R.id.btnLogout);

        //Setting the on click listener for the button
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        //Parsing
        // parser = new HandleXML(url1);
        //parser.fetchXML();
        //while (parser.parsingComplete) ;
        //Testing
        //Log.d("xmltest", parser.getCarParkIdentity());


        //Printing to emulator
        //  TextView tvXml = (TextView) findViewById(R.id.tvXml);
        //tvXml.setText(parser.getCarParkIdentity());




    }

    public void openCarParkInfo(){
        Intent intent = new Intent(this, CarParkInfo.class);
        startActivity(intent);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;
        //Setting the latitude and the longitude
        LatLng leeds = new LatLng( 53.6882243052201, -1.6336099285881425);
        //Adding the marker for the Map location( leeds)
        googleMap.addMarker(new MarkerOptions().position(leeds)
                .title("Marker in Leeds, UK"));
        //Setting map zoom level
        float zoomLevel = 16.0f;
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(leeds, zoomLevel));
        map.setOnInfoWindowClickListener(this);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "Info window clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
    // ------------------------JSOOOOOOON -----------------------
    /*public class MapFindActivity extends AppCompatActivity {

        private Button btnFind;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main5);

            btnFind = (Button)findViewById(R.id.btnFind);
            btnFind.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openCarParkData();
                }
            });

        }

        public void openCarParkData(){
            Intent intent = new Intent(this, CarParkData.class);
            startActivity(intent);
        }
    }*/
