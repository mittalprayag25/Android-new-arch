package com.prayag.arch;

import com.prayag.arch.application.CountdownApplication;
import com.prayag.arch.event.dao.DaggerEventDaoTest_MockCountdownComponent;
import com.prayag.arch.application.injection.MockCountdownModule;

/**
 * @author rebeccafranks
 * @since 2017/05/12.
 */

public class MockCountDownApplication extends CountdownApplication {

    @Override
    public CountdownComponent createCountdownComponent() {
        return DaggerEventDaoTest_MockCountdownComponent.builder()
                .mockCountdownModule(new MockCountdownModule(this)).build();
    }
}
