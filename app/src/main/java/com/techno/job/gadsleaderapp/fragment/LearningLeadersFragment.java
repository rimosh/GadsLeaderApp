package com.techno.job.gadsleaderapp.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techno.job.gadsleaderapp.R;
import com.techno.job.gadsleaderapp.adapter.RecyclerViewAdapter;
import com.techno.job.gadsleaderapp.model.LearnersLeadersInfo;
import com.techno.job.gadsleaderapp.services.LearningLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LearningLeadersFragment extends Fragment {

    public LearningLeadersFragment() {
        // Required empty public constructor
    }

    private static final String BASE_URL = "https://gadsapi.herokuapp.com";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_learning_leaders_fragment , container, false);
        final RecyclerView recyclerView;
        recyclerView = view.findViewById(R.id.learning_leaders_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        LearningLeaders learningLeadersApi = retrofit.create(LearningLeaders.class);
        learningLeadersApi.getLearners().enqueue(new Callback<List<LearnersLeadersInfo>>() {
            @Override
            public void onResponse(Call<List<LearnersLeadersInfo>> call, Response<List<LearnersLeadersInfo>> response) {
                recyclerView.setAdapter(new RecyclerViewAdapter(getContext(), response.body()));

            }

            @Override
            public void onFailure(Call<List<LearnersLeadersInfo>> call, Throwable t) {

            }
        });


        return view;
    }




}
