package ru.ivanova.githubclient.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.google.common.collect.ImmutableList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ivanova.githubclient.GithubClientApplication;
import ru.ivanova.githubclient.R;
import ru.ivanova.githubclient.data.model.Repository;
import ru.ivanova.githubclient.ui.activity.module.RepositoriesListActivityModule;
import ru.ivanova.githubclient.ui.activity.presenter.RepositoriesListActivityPresenter;
import ru.ivanova.githubclient.ui.adapter.RepositoriesListAdapter;


public class RepositoriesListActivity extends BaseActivity {
    @BindView(R.id.rvRepositories)
    RecyclerView rvRepositories;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;

    @Inject
    RepositoriesListActivityPresenter presenter;
    @Inject
    RepositoriesListAdapter repositoriesListAdapter;
    @Inject
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories_list);
        ButterKnife.bind(this);
        setupRepositoriesListView();
        presenter.loadRepositories();
    }

    private void setupRepositoriesListView() {
        rvRepositories.setAdapter(repositoriesListAdapter);
        rvRepositories.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void setupActivityComponent() {
        GithubClientApplication.get(this).getUserComponent()
                .plus(new RepositoriesListActivityModule(this))
                .inject(this);
    }

    public void showLoading(boolean loading) {
        rvRepositories.setVisibility(loading ? View.GONE : View.VISIBLE);
        pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
    }

    public void setRepositories(ImmutableList<Repository> repositories) {
        repositoriesListAdapter.updateRepositoriesList(repositories);
    }

    public void onRepositoryClick(Repository repository) {
        RepositoryDetailsActivity.startWithRepository(repository, this);
    }

    @Override
    public void finish() {
        super.finish();
        GithubClientApplication.get(this).releaseUserComponent();
    }
}
