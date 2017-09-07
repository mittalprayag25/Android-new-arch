package za.co.riggaroo.datecountdown.mmvm.SelfLearn.beans;

import javax.inject.Singleton;

/**
 * Created by pmittal on 05/09/17.
 */


public class Company {
    String companyName;
    String companyService;

    public String getCompanyName() {
        return "Xebia";
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyService() {
        return companyService;
    }

    public void setCompanyService(String companyService) {
        this.companyService = companyService;
    }


}
