package ru.ivanova.githubclient.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewTextChangeEvent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.ivanova.githubclient.GithubClientApplication;
import ru.ivanova.githubclient.R;
import ru.ivanova.githubclient.data.model.User;
import ru.ivanova.githubclient.ui.activity.module.SplashActivityModule;
import ru.ivanova.githubclient.ui.activity.presenter.SplashActivityPresenter;
import ru.ivanova.githubclient.utils.AnalyticsManager;
import rx.Subscription;
import rx.functions.Action1;


public class SplashActivity extends BaseActivity {

    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;
    @BindView(R.id.btnShowRepositories)
    Button btnShowRepositories;

    //These references will be satisfied by 'SplashActivityComponent.inject(this)' method
    @Inject
    SplashActivityPresenter presenter;
    @Inject
    AnalyticsManager analyticsManager;

    private Subscription textChangeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        analyticsManager.logScreenView(getClass().getName());

        textChangeSubscription = RxTextView.textChangeEvents(etUsername).subscribe(new Action1<TextViewTextChangeEvent>() {
            @Override
            public void call(TextViewTextChangeEvent textViewTextChangeEvent) {
                presenter.username = textViewTextChangeEvent.text().toString();
                etUsername.setError(null);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textChangeSubscription.unsubscribe();
    }

    //Local dependencies graph is constructed here
    @Override
    protected void setupActivityComponent() {
        //Uncomment those lines do measure dependencies creation time
        //Debug.startMethodTracing("SplashTrace");
        GithubClientApplication.get(this)
                .getAppComponent()
                .plus(new SplashActivityModule(this))
                .inject(this);
        //Debug.stopMethodTracing();
    }

    @OnClick(R.id.btnShowRepositories)
    public void onShowRepositoriesClick() {
        presenter.onShowRepositoriesClick();
    }

    public void showRepositoriesListForUser(User user) {
        GithubClientApplication.get(this).createUserComponent(user);
        startActivity(new Intent(this, RepositoriesListActivity.class));
    }

    public void showValidationError() {
        etUsername.setError("Validation error");
    }

    public void showLoading(boolean loading) {
        btnShowRepositories.setVisibility(loading ? View.GONE : View.VISIBLE);
        pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
    }
}
