package com.example.adrianmatuszewski.repoproject.Model.dataBaseModel;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author: Adrian Matuszewski
 */
public class Repo implements Serializable {

    @SerializedName(RepoConstants.KEY_ID)
    private int mId;
    @SerializedName(RepoConstants.KEY_NAME)
    private String mName;
    @SerializedName(RepoConstants.KEY_FULL_NAME)
    private String mFullName;
    @SerializedName(RepoConstants.KEY_OWNER)
    private Owner mOwner;
    @SerializedName(RepoConstants.KEY_HTML_URL)
    private String mHtmlUrl;
    @SerializedName(RepoConstants.KEY_DESCRIPTION)
    private String mDescription;
    @SerializedName(RepoConstants.KEY_URL)
    private String mUrl;
    @SerializedName(RepoConstants.KEY_STAR_GAZER_COUNT)
    private int mStarGazersCount;
    @SerializedName(RepoConstants.KEY_LANGUAGE)
    private String mLanguage;
    @SerializedName(RepoConstants.KEY_FORKS_COUNT)
    private int mForksCount;
    @SerializedName(RepoConstants.KEY_UPDATED_AT)
    private String mUpdatedAt;

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getFullName() {
        return mFullName;
    }

    public Owner getOwner() {
        return mOwner;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getUrl() {
        return mUrl;
    }

    public int getStarGazersCount() {
        return mStarGazersCount;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public int getForksCount() {
        return mForksCount;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }


    public interface RepoConstants {
        String KEY_ID = "id";
        String KEY_NAME = "name";
        String KEY_FULL_NAME = "full_name";
        String KEY_OWNER = "owner";
        String KEY_DESCRIPTION = "description";
        String KEY_HTML_URL = "html_url";
        String KEY_URL = "url";
        String KEY_STAR_GAZER_COUNT = "stargazers_count";
        String KEY_LANGUAGE = "language";
        String KEY_FORKS_COUNT = "forks_count";
        String KEY_UPDATED_AT = "updated_at";
    }
    
}
