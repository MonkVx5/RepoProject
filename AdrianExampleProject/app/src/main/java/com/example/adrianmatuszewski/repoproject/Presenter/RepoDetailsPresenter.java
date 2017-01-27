package com.example.adrianmatuszewski.repoproject.Presenter;

import com.example.adrianmatuszewski.repoproject.Model.RetrofitDataSource;
import com.example.adrianmatuszewski.repoproject.Model.dataBaseModel.Repo;
import com.example.adrianmatuszewski.repoproject.View.RepoDetailsView;

import android.content.Context;

/**
 * @author: Adrian Matuszewski
 */
public class RepoDetailsPresenter<T extends RepoDetailsView> extends Presenter<T>  {

    private int mId;

    private Repo mRepo;

    public RepoDetailsPresenter(final Context context) {}

    public void prepareChosenRepo(int id) {
        mId = id;
        mRepo = RetrofitDataSource.getInstance().getRepo(id);
        mView.setChosenRepo(mRepo);
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void finish() {

    }

}
