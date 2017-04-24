package com.avilevin.searchterm.api;

import android.content.Context;

import com.avilevin.searchterm.twitter.Utilities;
import com.crashlytics.android.Crashlytics;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.services.SearchService;

import io.fabric.sdk.android.Fabric;
import retrofit2.Call;

/**
 * Created by avilevin on 21/04/2017.
 */

public class SearchTerm {

    public static void init(Context context, String twitterKey, String twitterSecret) {
        final TwitterAuthConfig authConfig = new TwitterAuthConfig(twitterKey, twitterSecret);
        Fabric.with(context, new Twitter(authConfig));
        Fabric.with(context, new Crashlytics());
    }

    public static void searchTweetByName(String tweetName ,Callback<Search> callback) {

        String stringWithHashTag = Utilities.stringToHashTag(tweetName);
        if(stringWithHashTag != null) {
            TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient();
            SearchService searchService = twitterApiClient.getSearchService();

            String encodedTweetName = Utilities.encodeStringUTF8(tweetName);
            Call<Search> call = searchService.tweets(encodedTweetName,null,null,null,null,null,null,null,null,null);
            call.enqueue(callback);
        } else {
            Utilities.writeLog("something wrong, please check your hashtag tweet name",Utilities.LOG_LEVEL.ERROR);
        }
    }
}
