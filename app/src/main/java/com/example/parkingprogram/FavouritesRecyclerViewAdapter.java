package com.example.parkingprogram;

import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class FavouritesRecyclerViewAdapter extends RecyclerView.Adapter<FavouritesRecyclerViewAdapter.FavouritesViewHolder> {
    private List<HandleXML> favourites;
    private LayoutInflater inflater;


    public FavouritesRecyclerViewAdapter(Context context, List<HandleXML> favourites) {
        super();
        this.favourites = favourites;
        this.inflater = LayoutInflater.from(context);

    }

    public void setFavourites(List<HandleXML> favourites){
        this.favourites = favourites;
        notifyDataSetChanged();
    }

    @NonNull
    @Override

    public FavouritesRecyclerViewAdapter.FavouritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View favouritesView = this.inflater.inflate(R.layout.activity_main6, parent, false);
        FavouritesViewHolder viewHolder = new FavouritesViewHolder(this, favouritesView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavouritesRecyclerViewAdapter.FavouritesViewHolder holder, int postion) {
        HandleXML favouritesDisplayed = this.favourites.get(postion);

        TextView favouriteItemName = holder.itemView.findViewById(R.id.favouriteItemName);
        favouriteItemName.setText(favouritesDisplayed.getCarParkIdentity());

        TextView favouriteItemSelected = holder.itemView.findViewById(R.id.favouriteItemSelected);
        favouriteItemSelected.setText(favouritesDisplayed.isSelected() ? "Selected" : "");

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
            int position = getAdapterPosition();
            HandleXML clickedFavourite = favourites.get(position);
            clickedFavourite.setSelected(!clickedFavourite.isSelected());

            TextView favouriteItemSelected = itemView.findViewById(R.id.favouriteItemSelected);
            if (clickedFavourite.isSelected()) {
                favouriteItemSelected.setText("Selected Favourite");
            } else {
                favouriteItemSelected.setText("");
            }
        }
    }
}
