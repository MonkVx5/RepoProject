package com.example.adrianmatuszewski.repoproject.Model;



import com.example.adrianmatuszewski.repoproject.Model.dataBaseModel.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author: Adrian Matuszewski
 */
public interface RequestAPI {

    @GET("repos")
    Call<List<Repo>> getRepos();

}
