package ru.ivanova.githubclient.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.asksira.webviewsuite.WebViewSuite;

import java.text.SimpleDateFormat;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ivanova.githubclient.GithubClientApplication;
import ru.ivanova.githubclient.R;
import ru.ivanova.githubclient.data.model.Repository;
import ru.ivanova.githubclient.ui.activity.module.RepositoryDetailsActivityModule;
import ru.ivanova.githubclient.ui.activity.presenter.RepositoryDetailsActivityPresenter;
import ru.ivanova.githubclient.utils.AnalyticsManager;


public class RepositoryDetailsActivity extends BaseActivity {
    private static final String ARG_REPOSITORY = "arg_repository";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.textAuthor)
    TextView textAuthor;

    @BindView(R.id.textCreatedAt)
    TextView textCreatedAt;

    @BindView(R.id.textUpdatedAt)
    TextView textUpdatedAt;

    @BindView(R.id.textLanguage)
    TextView textLanguage;

    @BindView(R.id.textWatchers)
    TextView textWatchers;

    @BindView(R.id.textStars)
    TextView textStars;

    @BindView(R.id.buttonCode)
    Button buttonCode;

    @BindView(R.id.webViewSuite)
    WebViewSuite webViewSuite;

    @Inject
    AnalyticsManager analyticsManager;
    @Inject
    RepositoryDetailsActivityPresenter presenter;

    private Repository repository;

    public static void startWithRepository(Repository repository, Activity startingActivity) {
        Intent intent = new Intent(startingActivity, RepositoryDetailsActivity.class);
        intent.putExtra(ARG_REPOSITORY, repository);
        startingActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_details);
        ButterKnife.bind(this);
        analyticsManager.logScreenView(getClass().getName());

        repository = getIntent().getParcelableExtra(ARG_REPOSITORY);
        presenter.init();

        showData(repository);
    }

    private void showData(final Repository repository) {
        toolbar.setTitle(repository.name);
        toolbar.setSubtitle(repository.description);
        textAuthor.setText(repository.name);

        if (repository.created_at != null) {
            textCreatedAt.setText(new SimpleDateFormat("d MMMM YYYY").format(repository.created_at));
        } else {
            textCreatedAt.setText("Неизвестно");
        }

        if (repository.updated_at != null) {
            textUpdatedAt.setText(new SimpleDateFormat("d MMMM YYYY").format(repository.updated_at));
        } else {
            textUpdatedAt.setText("Неизвестно");
        }

        textLanguage.setText(repository.language);
        textWatchers.setText(String.valueOf(repository.watchers));
        textStars.setText(String.valueOf(repository.stargazers_count));
        webViewSuite.startLoading(repository.url);

        buttonCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonCode.setVisibility(View.GONE);
                webViewSuite.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    protected void setupActivityComponent() {
        GithubClientApplication.get(this).getUserComponent()
                .plus(new RepositoryDetailsActivityModule(this))
                .inject(this);
    }

    public void setupUserName(String userName) {
    }
}