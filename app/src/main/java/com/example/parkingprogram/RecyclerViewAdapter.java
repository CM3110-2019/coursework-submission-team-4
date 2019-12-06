package com.example.parkingprogram;

/*
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ModuleViewHolder> {

    private static final String TAG = RecyclerViewAdapter.class.getSimpleName();

    // holder for the data to be displayed
    private List<Module> modules;

    // will be used to inflate the Views that will be displayed by a RecyclerView
    private LayoutInflater inflater;


    public RecyclerViewAdapter(Context context, List<Module> data){
        // instantiate the member variables
        inflater = LayoutInflater.from(context);
        modules = data;
    }


    private static int counter = 0;


    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: " + ++counter);
        // Create a new view by inflating the layout defined in module_list_item.xml
        View itemView = inflater.inflate(R.layout.activity_module, parent, false );
        return new ModuleViewHolder(itemView, this);
    }

    */
/**
     * Called when binding a {@link ModuleViewHolder} to the item at position in this adapter's data
     * @param moduleViewHolder
     * @param position
     *//*

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder moduleViewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        // retrieve the Module at position from the data list
        Module currentModule = modules.get(position);

        // retrieve the TextView from the View that moduleViewHolder is holding
        TextView moduleTextView = moduleViewHolder.moduleItemView.findViewById(R.id.textView);

        // if registered is true for currentModule, display "registered" otherwise display "not registered"
        String registeredString = (currentModule.isRegistered())?"registered":"not registered";
        moduleTextView.setText(currentModule.getReference() + " (" + registeredString + ")");
    }

    */
/**
     * Returns the number of data items held by this adapter
     *//*

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return modules.size();
    }



    class ModuleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private View moduleItemView;
        private RecyclerViewAdapter adapter;

        public ModuleViewHolder(View itemView, RecyclerViewAdapter adapter){
            super(itemView);
            Log.d(TAG, "ModuleViewHolder: ");
            moduleItemView = itemView;
            this.adapter = adapter;
            moduleItemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: ");
            // get the clicked item's position
            int position = getAdapterPosition();

            // change the registered value for the clicked module
            Module clickedModule = modules.get(position);
            clickedModule.setRegistered(!clickedModule.isRegistered());
            // retrieve the TextView from the View that moduleViewHolder is holding
            TextView moduleTextView = v.findViewById(R.id.textView);

            // if registered is true for currentModule, display "registered" otherwise display "not registered"
            String registeredString = (clickedModule.isRegistered())?"registered":"not registered";
            moduleTextView.setText(clickedModule.getReference() + " (" + registeredString + ")");
        }
    }
}*/


