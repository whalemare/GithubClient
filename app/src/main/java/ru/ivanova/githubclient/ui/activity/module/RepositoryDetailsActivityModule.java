package ru.ivanova.githubclient.ui.activity.module;

import dagger.Module;
import dagger.Provides;
import ru.ivanova.githubclient.data.model.User;
import ru.ivanova.githubclient.ui.activity.ActivityScope;
import ru.ivanova.githubclient.ui.activity.RepositoryDetailsActivity;
import ru.ivanova.githubclient.ui.activity.presenter.RepositoryDetailsActivityPresenter;

/**
 * Created by Irina Ivanova on 23.04.19.
 */
@Module
public class RepositoryDetailsActivityModule {
    private RepositoryDetailsActivity repositoryDetailsActivity;

    public RepositoryDetailsActivityModule(RepositoryDetailsActivity repositoryDetailsActivity) {
        this.repositoryDetailsActivity = repositoryDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoryDetailsActivity provideRepositoryDetailsActivity() {
        return repositoryDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoryDetailsActivityPresenter provideRepositoryDetailsActivityPresenter(User user) {
        return new RepositoryDetailsActivityPresenter(repositoryDetailsActivity, user);
    }
}