package ru.ivanova.githubclient.ui.activity.module;

import dagger.Module;
import dagger.Provides;
import ru.ivanova.githubclient.data.api.UserManager;
import ru.ivanova.githubclient.ui.activity.ActivityScope;
import ru.ivanova.githubclient.ui.activity.SplashActivity;
import ru.ivanova.githubclient.ui.activity.presenter.SplashActivityPresenter;
import ru.ivanova.githubclient.utils.Validator;

/**
 * Created by Irina Ivanova on 23.04.19.
 */
@Module
public class SplashActivityModule {
    private SplashActivity splashActivity;

    public SplashActivityModule(SplashActivity splashActivity) {
        this.splashActivity = splashActivity;
    }

    @Provides
    @ActivityScope
    SplashActivity provideSplashActivity() {
        return splashActivity;
    }

    @Provides
    @ActivityScope
    SplashActivityPresenter
    provideSplashActivityPresenter(Validator validator, UserManager userManager) {
        return new SplashActivityPresenter(splashActivity, validator, userManager);
    }
}