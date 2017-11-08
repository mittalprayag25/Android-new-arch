package com.prayag.arch.sla.ui;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.prayag.arch.R;
import com.prayag.arch.sla.dao.Starships;
import com.prayag.arch.sla.viewmodel.StarshipsViewModel;

import java.util.List;

/**
 * Created by pmittal on 31/10/17.
 */

public class DeleteFragment extends LifecycleFragment {

    private Button buttonAddEvent;
    StarshipsViewModel starshipsViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_event, container, false);
        setupViews(view);
        buttonAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
            }
        });
        return view;
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        starshipsViewModel = ViewModelProviders.of(getActivity()).get(StarshipsViewModel.class);

        observeViewModel(starshipsViewModel);
    }

    /**
     *
     * @param viewModel
     */
    private void observeViewModel(StarshipsViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getStarshipsObservable().observe(this, new Observer<Starships>() {
            @Override
            public void onChanged(@Nullable Starships starships) {
                Log.d("sla fragment", starships.getNext());
            }
        });

    }

    public void updateData(){
        //starshipsViewModel.changeMessage("I am newly updated");
    }

    /**
     *
     * @param view
     */
    private void setupViews(View view) {
        buttonAddEvent = (Button) view.findViewById(R.id.button_add);
    }
}
