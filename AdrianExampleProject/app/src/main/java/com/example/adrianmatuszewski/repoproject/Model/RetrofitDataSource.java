package com.example.adrianmatuszewski.repoproject.Model;



import com.example.adrianmatuszewski.repoproject.Model.dataBaseModel.Repo;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @author: Adrian Matuszewski
 */
public class RetrofitDataSource implements DataSource {

    private static com.example.adrianmatuszewski.repoproject.Model.RetrofitDataSource
            ourInstance = new com.example.adrianmatuszewski.repoproject.Model.RetrofitDataSource();

    public static com.example.adrianmatuszewski.repoproject.Model.RetrofitDataSource getInstance() {
        return ourInstance;
    }

    private List<Repo> mListOfRepo;

    private Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl(Config.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private RequestAPI mAPI;

    private RetrofitDataSource() {

        mAPI = mRetrofit.create(RequestAPI.class);
    }

    @Override
    public void getRepos(final GenericCallback<List<Repo>> callbackResponse) {
        mAPI.getRepos().enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(final Call<List<Repo>> call, final Response<List<Repo>> response) {
                mListOfRepo = response.body();
                Log.d("getRepos", response.body().toString());
                callbackResponse.onSuccess(mListOfRepo);
            }

            @Override
            public void onFailure(final Call<List<Repo>> call, final Throwable t) {
                Log.d("getRepos", t.getMessage());
                Log.d("getRepos", "onFailure");
            }
        });

    }

    @Override
    public Repo getRepo(final int i) {
        Repo repo = null;
        if (mListOfRepo != null) {
            repo = mListOfRepo.get(i);
        }
        return repo;
    }


    private interface Config {
        String ENDPOINT = "https://api.github.com/users/google/";
    }

}
