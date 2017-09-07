package za.co.riggaroo.datecountdown.mmvm.SelfLearn;

import dagger.Component;
import za.co.riggaroo.datecountdown.mmvm.SelfLearn.beans.Company;
import za.co.riggaroo.datecountdown.mmvm.VehicleModule;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.ApplicationComponent;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.DaggerActivity;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.DataManager;
import za.co.riggaroo.datecountdown.mmvm.dagger2Impl.PerActivity;

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
