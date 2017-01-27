package com.example.adrianmatuszewski.repoproject.Model.dataBaseModel;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author: Adrian Matuszewski
 */
public class Owner implements Serializable {

    @SerializedName("login")
    private String mLogin;
    @SerializedName("id")
    private int mId;
    @SerializedName("avatar_url")
    private String mAvatarUrl;
    @SerializedName("gravatar_id")
    private String mGravatarId;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("html_url")
    private String mFollowersUrl;
    @SerializedName("followers_url")
    private String mFollowingUrl;
    @SerializedName("gists_url")
    private String mGistsUrl;
    @SerializedName("starred_url")
    private String mStarredUrl;
    @SerializedName("subscriptions_url")
    private String mSubscriptionsUrl;
    @SerializedName("organizations_url")
    private String mOrganizationsUrl;
    @SerializedName("repos_url")
    private String mReposUrl;
    @SerializedName("events_url")
    private String mEventsUrl;
    @SerializedName("received_events_url")
    private String mReceivedEventsUrl;
    @SerializedName("type")
    private String mType;
    @SerializedName("site_admin")
    private boolean mSiteAdmin;


    public Owner() {

    }


    public String getLogin() {
        return mLogin;
    }

    public int getId() {
        return mId;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public String getGravatarId() {
        return mGravatarId;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getFollowersUrl() {
        return mFollowersUrl;
    }

    public String getFollowingUrl() {
        return mFollowingUrl;
    }

    public String getGistsUrl() {
        return mGistsUrl;
    }

    public String getStarredUrl() {
        return mStarredUrl;
    }

    public String getSubscriptionsUrl() {
        return mSubscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return mOrganizationsUrl;
    }

    public String getReposUrl() {
        return mReposUrl;
    }

    public String getEventsUrl() {
        return mEventsUrl;
    }

    public String getReceivedEventsUrl() {
        return mReceivedEventsUrl;
    }

    public String getType() {
        return mType;
    }

    public boolean isSiteAdmin() {
        return mSiteAdmin;
    }
}
