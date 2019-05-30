package ru.ivanova.githubclient.utils;

import android.text.TextUtils;

/**
 * Created by Irina Ivanova on 23.04.19.
 */
public class Validator {

    public Validator() {
    }

    public boolean validUsername(String username) {
        return !TextUtils.isEmpty(username);
    }
}
