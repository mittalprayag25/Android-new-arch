package com.prayag.arch.user.ui;

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
import com.prayag.arch.user.dao.TechStack;
import com.prayag.arch.user.viewmodel.ProjectListViewModel;

import java.util.List;

/**
 * Created by pmittal on 11/09/17.
 */

public class DaggerFragment extends LifecycleFragment {

    //private ProjectAdapter projectAdapter;
    private EditText editTextTitle, editTextDescription;
    private Button buttonAddEvent, buttonSetDate;
    private TextView textViewCurrentDate;
    ProjectListViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(ProjectListViewModel.class);

        observeViewModel(viewModel);
    }

    private void observeViewModel(ProjectListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getProjectListObservable().observe(this, new Observer<List<TechStack>>() {
            @Override
            public void onChanged(@Nullable List<TechStack> projects) {
                if (projects != null) {
                    Log.d("In Dagger fragment", String.valueOf(projects.size()));
                    buttonAddEvent.setText(String.valueOf(projects.size()));
                }
            }
        });
        viewModel.getTestData().observe(this, new Observer<List<TechStack>>() {
            @Override
            public void onChanged(@Nullable List<TechStack> projects) {
                if (projects != null) {
                    Log.d("getTestData", String.valueOf(projects.size()));
                }
            }
        });
    }

    public void updateData(){
        TechStack techStack = new TechStack(12, "Anand");
        viewModel.addItem(techStack);
    }


    private void setupViews(View view) {
        buttonAddEvent = (Button) view.findViewById(R.id.button_add);
        textViewCurrentDate = (TextView) view.findViewById(R.id.text_view_date_set);
    }

}
