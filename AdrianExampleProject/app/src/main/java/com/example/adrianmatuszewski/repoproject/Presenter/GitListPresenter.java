package com.example.adrianmatuszewski.repoproject.Presenter;


import com.example.adrianmatuszewski.repoproject.Model.GenericCallback;
import com.example.adrianmatuszewski.repoproject.Model.RetrofitDataSource;
import com.example.adrianmatuszewski.repoproject.Model.dataBaseModel.Repo;
import com.example.adrianmatuszewski.repoproject.View.GitListView;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Adrian Matuszewski
 */
public class GitListPresenter<T extends GitListView> extends Presenter<T>  {

    private ProgressDialog mProgressDialog;
    private List<Repo> mListOfRepo;

    public GitListPresenter(final Context context) {

        setProgressBar(context);
        mListOfRepo = new ArrayList();
        getAllRepo();
    }



    public void getAllRepo() {

        RetrofitDataSource.getInstance().getRepos(new GenericCallback<List<Repo>>() {
            @Override
            public void onSuccess(final List<Repo> data) {
                Log.d("GitListPresenter", "onSuccess");
                mListOfRepo = data;
                mView.setList(mListOfRepo);
                turnOffProgressBar();
            }

            @Override
            public void onFailure(Exception error) {
                turnOffProgressBar();
                Log.d("GitListPresenter", "error");
            }
        });
    }

    private void setProgressBar(final Context context) {
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();
    }

    private void turnOffProgressBar() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
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
