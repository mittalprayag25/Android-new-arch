package com.prayag.arch.mmvm.SelfLearn;

import dagger.Component;
import com.prayag.arch.mmvm.SelfLearn.beans.Company;
import com.prayag.arch.mmvm.dagger2Impl.ApplicationComponent;
import com.prayag.arch.mmvm.dagger2Impl.DataManager;
import com.prayag.arch.mmvm.dagger2Impl.PerActivity;

/**
 * Created by pmittal on 05/09/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class ,modules = SelfModule.class)
public interface SelfComponent {

    Company provideCompany();

    void inject(DaggerSelfActivity activity);

    DataManager getDataManager();
}
