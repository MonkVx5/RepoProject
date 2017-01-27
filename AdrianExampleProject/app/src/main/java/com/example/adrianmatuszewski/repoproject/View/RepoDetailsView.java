package com.example.adrianmatuszewski.repoproject.View;



import com.example.adrianmatuszewski.repoproject.Model.dataBaseModel.Repo;

import android.content.Context;

/**
 * @author: Adrian Matuszewski
 */
public interface RepoDetailsView extends BaseView  {

    Context getContext();

    void setChosenRepo(final Repo repo);


}
