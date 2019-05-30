package ru.ivanova.githubclient;

import javax.inject.Singleton;

import dagger.Component;
import ru.ivanova.githubclient.data.api.GithubApiModule;
import ru.ivanova.githubclient.data.UserComponent;
import ru.ivanova.githubclient.data.api.UserModule;
import ru.ivanova.githubclient.ui.activity.component.SplashActivityComponent;
import ru.ivanova.githubclient.ui.activity.module.SplashActivityModule;

/**
 * Created by Irina Ivanova on 22.04.19.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                GithubApiModule.class
        }
)
public interface AppComponent {

    SplashActivityComponent plus(SplashActivityModule module);

    UserComponent plus(UserModule userModule);

}