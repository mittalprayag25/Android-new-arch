package com.prayag.arch.ui.event.add;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Completable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

import com.prayag.arch.event.viewmodel.AddEventViewModel;
import com.prayag.arch.event.injection.EventRepository;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author rebeccafranks
 * @since 2017/05/09.
 */
public class AddEventViewModelTest {

    AddEventViewModel addEventViewModel;

    @Mock
    EventRepository eventRepository;

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();


    @BeforeClass
    public static void setUpClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(__ -> Schedulers.trampoline());
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        addEventViewModel = new AddEventViewModel();
        addEventViewModel.eventRepository = eventRepository;
    }

    @AfterClass
    public static void tearDownClass() {
        RxAndroidPlugins.reset();
    }

    @Test
    public void addEvent() {
        when(eventRepository.addEvent(any())).thenReturn(Completable.complete());

        addEventViewModel.addEvent();

        verify(eventRepository).addEvent(any());
    }
}