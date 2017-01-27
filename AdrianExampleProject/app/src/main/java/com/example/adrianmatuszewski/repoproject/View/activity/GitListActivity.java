package com.example.adrianmatuszewski.repoproject.View.activity;


import com.example.adrianmatuszewski.repoproject.Model.dataBaseModel.Repo;
import com.example.adrianmatuszewski.repoproject.Presenter.GitListPresenter;
import com.example.adrianmatuszewski.repoproject.R;
import com.example.adrianmatuszewski.repoproject.View.GitListView;
import com.example.adrianmatuszewski.repoproject.View.adapter.RecyclerAdapter;
import com.example.adrianmatuszewski.repoproject.View.adapter.RecyclerViewItemClickListener;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Adrian Matuszewski
 */
public class GitListActivity extends AppCompatActivity implements GitListView {

    @BindView(R.id.list_of_repos)
    RecyclerView mListOfRepo;
    
    private GitListPresenter mGitListPresenter;

    private RecyclerAdapter mRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_list);
        ButterKnife.bind(this);

        mGitListPresenter = new GitListPresenter(this);
        mGitListPresenter.setView(this);
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void setList(final List<Repo> list) {

        mRecyclerAdapter = new RecyclerAdapter(this, list, R.layout.repo_item);

        mListOfRepo.setAdapter(mRecyclerAdapter);

        mListOfRepo.setHasFixedSize(true);
        mListOfRepo.setLayoutManager(new LinearLayoutManager(this));

        mListOfRepo.setItemAnimator(new DefaultItemAnimator());
        mListOfRepo.addOnItemTouchListener(new RecyclerViewItemClickListener(this, new RecyclerViewItemClickListener.OnItemClickListener() {
            @Override
            public boolean onItemClick(final View view, final int position) {
                Log.d("List", " : " + position);
                showRepoDetails(position);
                return true;
            }
        }));
    }

    @Override
    public void showRepoDetails(final int chosenRepo) {
        Bundle repoToOpen = new Bundle();
        repoToOpen.putSerializable(RepoDetailsActivity.PARAM_EXTRA, chosenRepo);
        Intent intent = new Intent(this, RepoDetailsActivity.class);
        intent.putExtras(repoToOpen);
        startActivity(intent);
    }

}
