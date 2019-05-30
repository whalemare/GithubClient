package ru.ivanova.githubclient.data.api;

import dagger.Module;
import dagger.Provides;
import ru.ivanova.githubclient.data.UserScope;
import ru.ivanova.githubclient.data.model.User;

/**
 * Created by Irina Ivanova on 23.06.19.
 */
@Module
public class UserModule {

    private User user;

    public UserModule(User user) {
        this.user = user;
    }

    @Provides
    @UserScope
    User provideUser() {
        return user;
    }

    @Provides
    @UserScope
    RepositoriesManager provideRepositoriesManager(User user, GithubApiService githubApiService) {
        return new RepositoriesManager(user, githubApiService);
    }
}
