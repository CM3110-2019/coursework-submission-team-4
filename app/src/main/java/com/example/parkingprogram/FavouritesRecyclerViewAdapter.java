/*
package com.example.parkingprogram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavouritesRecyclerViewAdapter extends RecyclerView.Adapter<FavouritesRecyclerViewAdapter.FavouritesViewHolder> {
    private List<FavouritesActivity> favourites;
    private LayoutInflater inflater;

    public FavouritesRecyclerViewAdapter(Context context, List<FavouritesActivity> favourites){
        super();
        this.favourites = favourites;
        this.inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override

    public FavouritesRecyclerViewAdapter.FavouritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View favouritesView = this.inflater.inflate(R.layout.location_list_item, parent, false);
        FavouritesViewHolder viewHolder = new FavouritesViewHolder(this. favouritesView);
        return favouritesView;
    }

    @Override
    public void onBindViewHolder(@nonNull FavouritesRecyclerViewAdapter.FavouritesViewHolder holder, int postion) {
        Favourites favouritesDisplayed = this.favourites.get(postion);

        TextView tvListItemName = holder.itemView.findViewById(R.id.tvListItemName);
        tvListItemName.setText(favouritesDisplayed.getName());

        TextView tvListItemSelected = holder.itemView.findViewById(R.id.tvListItemSelected);
        tvListItemSelected.setText(favouritesDisplayed.isSelected() ? "selected" : "");


    }

    @Override
    public int getItemCount() {
        return this.favourites.size();
    }

    class FavouritesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private FavouritesRecyclerViewAdapter adapter;
        private View itemView;

        public FavouritesViewHolder(FavouritesRecyclerViewAdapter adapter, View itemView) {
            super(itemView);
            this.adapter = adapter;
            this.itemView = itemView;
            this.itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPostion();
            Favourites clickedFavourite = favourites.get(position);
            clickedFavourite.setSelected(!clickedFavourite.isSelected());

            TextView tvListItemSelected = itemView.findByViewId(R.id.tvListItemSelected);
            if (clickedFavourite.isSelected()) {
                tvListItemSelected.setText("Selected Favourite");
            } else {
                tvListItemSelected.setText("");
            }
        }
    }
*/
