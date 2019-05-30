package ru.ivanova.githubclient.ui.activity.module;

import dagger.Provides;
import ru.ivanova.githubclient.data.api.UserManager;
import ru.ivanova.githubclient.ui.activity.ActivityScope;
import ru.ivanova.githubclient.ui.activity.SplashActivity;
import ru.ivanova.githubclient.ui.activity.presenter.SplashActivityPresenter;
import ru.ivanova.githubclient.utils.Validator;

import static org.mockito.Mockito.mock;

/**
 * Created by Irina Ivanova on 20.05.19.
 */
public class MockSplashActivityModule extends SplashActivityModule {

    public MockSplashActivityModule(SplashActivity splashActivity) {
        super(splashActivity);
    }

    @Provides
    @ActivityScope
    SplashActivityPresenter provideSplashActivityPresenter(Validator validator, UserManager userManager) {
        return mock(SplashActivityPresenter.class);
    }
}
