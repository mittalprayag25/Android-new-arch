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
import android.widget.EditText;
import android.widget.TextView;

import com.prayag.arch.R;
import com.prayag.arch.sla.dao.Starships;
import com.prayag.arch.sla.injection.components.DaggerTestGagComponent;
import com.prayag.arch.sla.injection.components.TestGagComponent;
import com.prayag.arch.sla.injection.modules.TestGagModule;
import com.prayag.arch.sla.viewmodel.StarshipsViewModel;

/**
 * Created by pmittal on 31/10/17.
 */

public class SlaFragment extends LifecycleFragment {

    //private ProjectAdapter projectAdapter;
    private EditText editTextTitle, editTextDescription;
    private Button buttonAddEvent, buttonSetDate;
    private TextView textViewCurrentDate;
    StarshipsViewModel starshipsViewModel;
    TestGagComponent testGagComponent;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(testGagComponent == null){
            testGagComponent = DaggerTestGagComponent.builder()
                    .testGagModule(new TestGagModule(getActivity()))
                    .build();
        }
        testGagComponent.inject(SlaFragment.this);
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
              //      User user = dataManager.getUser(1L);
                }catch (Exception e){e.printStackTrace();}
               // updateData();
            }
        });
        return view;
    }

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
       // starshipsViewModel.changeMessage("I am newly updated");
    }


    private void setupViews(View view) {
        buttonAddEvent = (Button) view.findViewById(R.id.button_add);
    }
}
