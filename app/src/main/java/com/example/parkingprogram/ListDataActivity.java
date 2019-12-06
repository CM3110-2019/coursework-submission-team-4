package com.example.parkingprogram;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListDataActivity extends AppCompatActivity {
    private HandleXML parser;
    private TextView tvPrint, tvText, tvPrint1, tvPrint2, tvPrint3;

    //Getting the API
    private String url1 = "http://www.leedstravel.info/datex2/carparks/content.xml";
    private String url2 = "&mode=xml";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);


        //Parsing
        parser = new HandleXML(url1);
        Log.d("sam", "Before fetchXML");
        parser.fetchXML();
        while (parser.parsingComplete) ;

        //Testing
        Log.d("name", parser.getCarParkIdentity());
        Log.d("occupancy", parser.getCarParkOccupancy());
        Log.d("spaces taken", parser.getOccupiedSpaces());
        Log.d("capacity", parser.getTotalCapacity());

        //Printing on textview
        TextView tvprint = (TextView) findViewById(R.id.tvPrint);
        tvprint.setText(parser.getCarParkIdentity());

        //tvprint.setText(parser.getCarParkOccupancy());

        //tvprint.setText(parser.getOccupiedSpaces());

       // tvprint.setText(parser.getTotalCapacity());

        TextView tvText = (TextView) findViewById(R.id.tvText);
        tvText.setText("Here you can see the car park information");
    }

}




