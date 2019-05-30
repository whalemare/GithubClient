package ru.ivanova.githubclient.ui.activity.presenter;

import ru.ivanova.githubclient.data.model.User;
import ru.ivanova.githubclient.ui.activity.RepositoryDetailsActivity;

/**
 * Created by Irina Ivanova on 23.04.19.
 */
public class RepositoryDetailsActivityPresenter {
    private RepositoryDetailsActivity repositoryDetailsActivity;
    private User user;

    public RepositoryDetailsActivityPresenter(RepositoryDetailsActivity repositoryDetailsActivity, User user) {
        this.repositoryDetailsActivity = repositoryDetailsActivity;
        this.user = user;
    }

    public void init() {
        repositoryDetailsActivity.setupUserName(user.login);
    }
}
