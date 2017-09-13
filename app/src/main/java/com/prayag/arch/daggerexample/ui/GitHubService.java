package com.prayag.arch.daggerexample.ui;

import com.prayag.arch.daggerexample.dao.TechStack;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by pmittal on 12/09/17.
 */

public interface GitHubService {
    String HTTPS_API_GITHUB_URL = "http://10.0.2.2:8000/api/";  // BAse url must end  with "/"

    @GET("test")
    Call<List<TechStack>> getProjectList();

}
