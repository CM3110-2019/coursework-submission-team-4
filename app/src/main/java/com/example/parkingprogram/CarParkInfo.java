package com.example.parkingprogram;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarParkInfo extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_park_info);

        // get some mock data
        List<Module> moduleList = createModules(50);

        // get a handle to the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);

        // create an adapter with the mock data
        adapter = new RecyclerViewAdapter(this, moduleList);

        // connect the adapter with the recycler view
        recyclerView.setAdapter(adapter);

        // give the recycler view a layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<Module> createModules(int number){
        List<Module> modules = new ArrayList<Module>(number);
        for (int i = 0; i < number; i++){
            Module module = createModule("CM300" + i);
            modules.add(module);
        }
        return modules;
    }

    private Module createModule(String reference){
        Module m = new Module();
        m.setReference(reference);
        m.setRegistered(false);
        m.setScqfCredits(15);
        m.setCreatedOn(new Date());
        return m;
    }
}
