package ru.ivanova.githubclient.utils;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Irina Ivanova on 23.04.19.
 */
public class AnalyticsManager {

    private Application app;

    public AnalyticsManager(Application app) {
        this.app = app;
    }

    public void logScreenView(String screenName) {
        Timber.d("Logged screen name: " + screenName);
    }
}

