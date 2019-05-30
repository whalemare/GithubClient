package ru.ivanova.githubclient.ui.activity.presenter;

import ru.ivanova.githubclient.data.api.UserManager;
import ru.ivanova.githubclient.data.model.User;
import ru.ivanova.githubclient.ui.activity.SplashActivity;
import ru.ivanova.githubclient.utils.SimpleObserver;
import ru.ivanova.githubclient.utils.Validator;

/**
 * Created by Irina Ivanova on 23.04.19.
 */
public class SplashActivityPresenter {
    public String username;

    private SplashActivity splashActivity;
    private Validator validator;
    private UserManager userManager;

    public SplashActivityPresenter(SplashActivity splashActivity, Validator validator,
                                   UserManager userManager) {
        this.splashActivity = splashActivity;
        this.validator = validator;
        this.userManager = userManager;
    }

    public void onShowRepositoriesClick() {
        if (validator.validUsername(username)) {
            splashActivity.showLoading(true);
            userManager.getUser(username).subscribe(new SimpleObserver<User>() {
                @Override
                public void onNext(User user) {
                    splashActivity.showLoading(false);
                    splashActivity.showRepositoriesListForUser(user);
                }

                @Override
                public void onError(Throwable e) {
                    splashActivity.showLoading(false);
                    splashActivity.showValidationError();
                }
            });
        } else {
            splashActivity.showValidationError();
        }
    }
}
