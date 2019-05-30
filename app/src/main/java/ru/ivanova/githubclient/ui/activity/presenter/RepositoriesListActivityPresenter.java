package ru.ivanova.githubclient.ui.activity.presenter;

import com.google.common.collect.ImmutableList;

import ru.ivanova.githubclient.data.api.RepositoriesManager;
import ru.ivanova.githubclient.data.model.Repository;
import ru.ivanova.githubclient.ui.activity.RepositoriesListActivity;
import ru.ivanova.githubclient.utils.SimpleObserver;

/**
 * Created by Irina Ivanova on 23.04.19.
 */
public class RepositoriesListActivityPresenter {
    private RepositoriesListActivity repositoriesListActivity;
    private RepositoriesManager repositoriesManager;

    public RepositoriesListActivityPresenter(RepositoriesListActivity repositoriesListActivity,
                                             RepositoriesManager repositoriesManager) {
        this.repositoriesListActivity = repositoriesListActivity;
        this.repositoriesManager = repositoriesManager;
    }

    public void loadRepositories() {
        repositoriesListActivity.showLoading(true);
        repositoriesManager.getUsersRepositories().subscribe(new SimpleObserver<ImmutableList<Repository>>() {
            @Override
            public void onNext(ImmutableList<Repository> repositories) {
                repositoriesListActivity.showLoading(false);
                repositoriesListActivity.setRepositories(repositories);
            }

            @Override
            public void onError(Throwable e) {
                repositoriesListActivity.showLoading(false);
            }
        });
    }

}
