package ru.ivanova.githubclient.inject;

import ru.ivanova.githubclient.data.api.GithubApiModule;
import ru.ivanova.githubclient.data.api.GithubApiService;
import ru.ivanova.githubclient.data.api.UserManager;

/**
 * Created by Irina Ivanova on 23.05.19.
 */
public class GithubApiModuleMock extends GithubApiModule {

    private UserManager userManagerMock;

    public GithubApiModuleMock(UserManager userManagerMock) {
        this.userManagerMock = userManagerMock;
    }

    @Override
    public UserManager provideUserManager(GithubApiService githubApiService) {
        return userManagerMock;
    }
}
