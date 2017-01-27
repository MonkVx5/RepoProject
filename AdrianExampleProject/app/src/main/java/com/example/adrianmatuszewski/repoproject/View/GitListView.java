package com.example.adrianmatuszewski.repoproject.View;




import com.example.adrianmatuszewski.repoproject.Model.dataBaseModel.Repo;

import android.content.Context;

import java.util.List;

/**
 * @author: Adrian Matuszewski
 */
public interface GitListView extends BaseView{

    Context getContext();

    void setList(List<Repo> list);

    void showRepoDetails(final int chosenRepo);


}
