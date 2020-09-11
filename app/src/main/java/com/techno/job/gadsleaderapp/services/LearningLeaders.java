package com.techno.job.gadsleaderapp.services;

import com.techno.job.gadsleaderapp.model.LearnersLeadersInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningLeaders {


    @GET("/api/hours")
    Call<List<LearnersLeadersInfo>> getLearners();
}
