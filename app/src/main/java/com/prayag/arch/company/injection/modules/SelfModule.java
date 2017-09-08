package com.prayag.arch.company.injection.modules;


import com.prayag.arch.company.dao.Company;

import dagger.Module;
import dagger.Provides;

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
