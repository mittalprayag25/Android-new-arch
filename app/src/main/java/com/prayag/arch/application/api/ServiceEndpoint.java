package com.prayag.arch.application.api;

import com.prayag.arch.sla.dao.CitizenAlert;
import com.prayag.arch.user.dao.TechStack;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pmittal on 12/09/17.
 */

public interface ServiceEndpoint {
    String HTTPS_API_GITHUB_URL = "http://10.0.2.2:8000/api/";  // BAse url must end  with "/"

    @GET("test")
    Call<List<TechStack>> getProjectList();

    @GET("alerts")
    Call<List<CitizenAlert>> getCitizenAlerts();

}
