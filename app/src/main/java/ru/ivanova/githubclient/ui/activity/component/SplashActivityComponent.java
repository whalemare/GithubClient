package ru.ivanova.githubclient.ui.activity.component;

import dagger.Subcomponent;
import ru.ivanova.githubclient.ui.activity.ActivityScope;
import ru.ivanova.githubclient.ui.activity.SplashActivity;
import ru.ivanova.githubclient.ui.activity.module.SplashActivityModule;

/**
 * Created by Irina Ivanova on 23.04.19.
 */
@ActivityScope
@Subcomponent(
        modules = SplashActivityModule.class
)
public interface SplashActivityComponent {

    SplashActivity inject(SplashActivity splashActivity);

}