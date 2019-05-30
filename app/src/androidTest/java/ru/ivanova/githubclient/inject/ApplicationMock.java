package ru.ivanova.githubclient.inject;

import ru.ivanova.githubclient.AppComponent;
import ru.ivanova.githubclient.AppModule;
import ru.ivanova.githubclient.DaggerAppComponent;
import ru.ivanova.githubclient.GithubClientApplication;
import ru.ivanova.githubclient.data.api.GithubApiModule;

public class ApplicationMock extends GithubClientApplication {

    private AppComponent appComponent;
    private GithubApiModule githubApiModuleMock;

    public void setGithubApiModuleMock(GithubApiModule githubApiModuleMock) {
        this.githubApiModuleMock = githubApiModuleMock;
        setupMockAppComponent();
    }

    public void setupMockAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .githubApiModule(githubApiModuleMock)
                .build();
    }

    @Override
    public AppComponent getAppComponent() {
        return appComponent == null ? super.getAppComponent() : appComponent;
    }
}