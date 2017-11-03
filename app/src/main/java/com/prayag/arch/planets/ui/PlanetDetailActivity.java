package com.prayag.arch.planets.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.prayag.arch.R;

/**
 * Created by pmittal on 03/11/17.
 */

public class PlanetDetailActivity extends LifecycleActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_detail);
    }
}
