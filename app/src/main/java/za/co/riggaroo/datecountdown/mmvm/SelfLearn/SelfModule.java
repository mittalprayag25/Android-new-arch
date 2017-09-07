package za.co.riggaroo.datecountdown.mmvm.SelfLearn;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import za.co.riggaroo.datecountdown.mmvm.SelfLearn.beans.Company;

/**
 * Created by pmittal on 05/09/17.
 */

@Module
public class SelfModule {

    @Provides
    Company provideCompanies(){
        return new Company();
    }

}
