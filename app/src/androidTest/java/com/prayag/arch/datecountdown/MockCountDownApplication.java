package com.prayag.arch;

import com.prayag.arch.dao.DaggerEventDaoTest_MockCountdownComponent;
import com.prayag.arch.injection.CountdownComponent;
import com.prayag.arch.injection.MockCountdownModule;

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
