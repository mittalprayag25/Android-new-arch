package com.prayag.arch.planets.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.prayag.arch.R;

public class PlanetsViewHolder extends RecyclerView.ViewHolder {

    TextView planetTextView;
    TextView climateTextView;
    TextView terrainTextView;
    ImageButton deleteButton;

    PlanetsViewHolder(View v) {
        super(v);
        planetTextView = (TextView) v.findViewById(R.id.text_view_planet_name);
        climateTextView = (TextView) v.findViewById(R.id.text_view_climate);
        terrainTextView = (TextView) v.findViewById(R.id.text_view_terrain);
        deleteButton = (ImageButton) v.findViewById(R.id.button_delete);
    }
}
