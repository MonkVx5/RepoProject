package com.example.adrianmatuszewski.repoproject.View.activity;


import com.example.adrianmatuszewski.repoproject.Model.dataBaseModel.Repo;
import com.example.adrianmatuszewski.repoproject.Presenter.RepoDetailsPresenter;
import com.example.adrianmatuszewski.repoproject.R;
import com.example.adrianmatuszewski.repoproject.View.RepoDetailsView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author: Adrian Matuszewski
 */
public class RepoDetailsActivity extends AppCompatActivity implements RepoDetailsView {

    public static final String PARAM_EXTRA = "param.repo";

    private RepoDetailsPresenter mRepoDetailsPresenter;

    @BindView(R.id.repo_name)
    TextView mName;
    @BindView(R.id.repo_description)
    TextView mDescription;
    @BindView(R.id.repo_language)
    TextView mLanguage;
    @BindView(R.id.repo_stars)
    TextView mStars;
    @BindView(R.id.repo_update)
    TextView mUpdate;
    @BindView(R.id.repo_owner)
    TextView mOwner;
    private String mUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_details);
        ButterKnife.bind(this);
        mRepoDetailsPresenter = new RepoDetailsPresenter(this);
        mRepoDetailsPresenter.setView(this);

        if (getIntent().getExtras() != null) {
            Bundle chosenRepo = getIntent().getExtras();
            int repoId = chosenRepo.getInt(PARAM_EXTRA);
            mRepoDetailsPresenter.prepareChosenRepo(repoId);
        } else {
            throw new RuntimeException("This activity should always have some extras");
        }

    }
    
    @Override
    public void setChosenRepo(final Repo repo) {
        mName.setText(repo.getName());
        mDescription.setText(repo.getDescription());
        mLanguage.setText(repo.getLanguage());
        mStars.setText(String.valueOf(repo.getStarGazersCount()));
        mUpdate.setText("Updated: " + repo.getUpdatedAt());
        mOwner.setText("Owner login: " + repo.getOwner().getLogin());
        mUrl = repo.getHtmlUrl();
   }

    @Override
    public Context getContext() {
        return this;
    }

    @OnClick(R.id.repo_url)
    public void openUrl() {
        if(!mUrl.isEmpty()) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mUrl)));
        }
    }

}
