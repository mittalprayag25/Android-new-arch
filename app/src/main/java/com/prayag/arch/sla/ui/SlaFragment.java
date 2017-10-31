package com.prayag.arch.sla.ui;

import android.app.Fragment;
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
import android.widget.EditText;
import android.widget.TextView;

import com.prayag.arch.R;
import com.prayag.arch.application.data.DataManager;
import com.prayag.arch.sla.dao.CitizenAlert;
import com.prayag.arch.sla.viewmodel.SlaViewModel;
import com.prayag.arch.user.dao.TechStack;
import com.prayag.arch.user.dao.User;
import com.prayag.arch.user.viewmodel.ProjectListViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pmittal on 31/10/17.
 */

public class SlaFragment extends LifecycleFragment {

    //private ProjectAdapter projectAdapter;
    private EditText editTextTitle, editTextDescription;
    private Button buttonAddEvent, buttonSetDate;
    private TextView textViewCurrentDate;
    SlaViewModel slaViewModel;

    @Inject
    DataManager dataManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_event, container, false);
        setupViews(view);
        buttonAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    User user = dataManager.getUser(1L);
                }catch (Exception e){e.printStackTrace();}
               // updateData();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        slaViewModel = ViewModelProviders.of(getActivity()).get(SlaViewModel.class);

        observeViewModel(slaViewModel);
    }

    private void observeViewModel(SlaViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getcitizenListObservable().observe(this, new Observer<List<CitizenAlert>>() {
            @Override
            public void onChanged(@Nullable List<CitizenAlert> citizenAlerts) {
                Log.d("sla fragment", citizenAlerts.get(0).getMessage());
            }
        });

    }

    public void updateData(){
        slaViewModel.changeMessage("I am newly updated");
    }


    private void setupViews(View view) {
        buttonAddEvent = (Button) view.findViewById(R.id.button_add);
    }
}
