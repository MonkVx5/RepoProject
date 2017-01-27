package com.example.adrianmatuszewski.repoproject.Model;



import com.example.adrianmatuszewski.repoproject.Model.dataBaseModel.Repo;

import java.util.List;

/**
 * @author: Adrian Matuszewski
 */
public interface DataSource {

    void getRepos(GenericCallback<List<Repo>> callbackResponse);

    Repo getRepo(int i);

}
