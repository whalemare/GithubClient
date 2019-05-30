package ru.ivanova.githubclient.ui.activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import ru.ivanova.githubclient.BuildConfig;
import ru.ivanova.githubclient.TestGithubClientApplication;
import ru.ivanova.githubclient.ui.activity.component.SplashActivityComponent;
import ru.ivanova.githubclient.utils.AnalyticsManager;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

/**
 * Created by Irina Ivanova on 19.05.19.
 */
@RunWith(RobolectricTestRunner.class)
@Config(
        sdk = 18,
        constants = BuildConfig.class,
        application = TestGithubClientApplication.class
)
public class SplashActivityTests {

    @Mock
    SplashActivityComponent splashActivityComponentMock;
    @Mock
    AnalyticsManager analyticsManagerMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) {
                SplashActivity activity = (SplashActivity) invocation.getArguments()[0];
                activity.analyticsManager = analyticsManagerMock;
                return null;
            }
        }).when(splashActivityComponentMock).inject(any(SplashActivity.class));

        TestGithubClientApplication app = (TestGithubClientApplication) RuntimeEnvironment.application;
        app.setSplashActivityComponent(splashActivityComponentMock);
    }

    @Test
    public void testName() throws Exception {
        SplashActivity activity = Robolectric.setupActivity(SplashActivity.class);
        verify(activity.analyticsManager).logScreenView(anyString());
    }
}
