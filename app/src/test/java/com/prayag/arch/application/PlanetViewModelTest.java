package com.prayag.arch.application;

import android.app.Application;
import android.content.Context;

import com.prayag.arch.planets.viewmodel.PlanetViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by pmittal on 06/11/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class PlanetViewModelTest {

    @Mock
    Application application;

    @InjectMocks
    PlanetViewModel mockPlanetViewModel = new PlanetViewModel(application);

    @Test
    public void addEvent() {
        assertEquals(1, 1);
        assertEquals(mockPlanetViewModel.test(), "prayag");
    }

    @Test
    public void testGetplanetsListObservable(){
    }

}
