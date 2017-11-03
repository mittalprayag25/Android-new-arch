package com.prayag.arch.planets.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.prayag.arch.R;
import com.prayag.arch.planets.dao.Planet;
import com.prayag.arch.planets.dao.Planets;

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsViewHolder> {
    private final Context context;
    private List<Planet> items;
    private View.OnClickListener deleteClickListener;
    private View.OnClickListener viewClickListener;

    public PlanetsAdapter(List<Planet> items, Context context, View.OnClickListener viewClickListener, View.OnClickListener deleteClickListener) {
        this.items = items;
        this.context = context;
        this.deleteClickListener = deleteClickListener;
        this.viewClickListener = viewClickListener;
    }

    @Override
    public PlanetsViewHolder onCreateViewHolder(ViewGroup parent,
                                                int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_event, parent, false);
        return new PlanetsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PlanetsViewHolder holder, int position) {
        Planet planet = items.get(position);
        holder.planetTextView.setText(planet.getName());
        holder.terrainTextView.setText(planet.getTerrain());
        holder.climateTextView.setText(planet.getClimate());
        holder.itemView.setTag(planet);
        holder.deleteButton.setTag(planet);
        holder.deleteButton.setOnClickListener(deleteClickListener);
        holder.itemView.setOnClickListener(viewClickListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Planet> planets) {
        this.items = planets;
        notifyDataSetChanged();
    }
}