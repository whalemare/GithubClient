package ru.ivanova.githubclient;

import android.app.Application;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ru.ivanova.githubclient.utils.AnalyticsManager;

/**
 * Created by Irina Ivanova on 20.05.19.
 */
public class MockAppModule extends AppModule {
    @Mock
    AnalyticsManager analyticsManagerMock;

    public MockAppModule(Application application) {
        super(application);
        MockitoAnnotations.initMocks(this);
    }

    @Override
    AnalyticsManager provideAnalyticsManager() {
        return analyticsManagerMock;
    }
}