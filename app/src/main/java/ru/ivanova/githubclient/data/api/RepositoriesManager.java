package ru.ivanova.githubclient.data.api;

import com.google.common.collect.ImmutableList;

import java.util.List;

import ru.ivanova.githubclient.data.api.response.RepositoryResponse;
import ru.ivanova.githubclient.data.model.Repository;
import ru.ivanova.githubclient.data.model.User;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Irina Ivanova on 22.04.19.
 */
public class RepositoriesManager {
    private User user;
    private GithubApiService githubApiService;

    public RepositoriesManager(User user, GithubApiService githubApiService) {
        this.user = user;
        this.githubApiService = githubApiService;
    }

    public Observable<ImmutableList<Repository>> getUsersRepositories() {
        return githubApiService.getUsersRepositories(user.login)
                .map(new Func1<List<RepositoryResponse>, ImmutableList<Repository>>() {
                    @Override
                    public ImmutableList<Repository> call(List<RepositoryResponse> repositoriesListResponse) {
                        final ImmutableList.Builder<Repository> listBuilder = ImmutableList.builder();
                        for (RepositoryResponse repositoryResponse : repositoriesListResponse) {
                            Repository repository = new Repository();
                            repository.id = repositoryResponse.id;
                            repository.name = repositoryResponse.name;
                            repository.url = repositoryResponse.url;
                            repository.stargazers_count = repositoryResponse.stargazers_count;
                            repository.forks_count = repositoryResponse.forks_count;
                            repository.full_name = repositoryResponse.full_name;
                            repository.open_issues_count = repositoryResponse.open_issues_count;
                            repository.forks = repositoryResponse.forks;
                            repository.open_issues = repositoryResponse.open_issues;
                            repository.watchers = repositoryResponse.watchers;
                            repository.full_name = repositoryResponse.full_name;
                            repository.language = repositoryResponse.language;
                            repository.created_at = repositoryResponse.created_at;
                            repository.updated_at = repositoryResponse.updated_at;
                            repository.description = repositoryResponse.description;
                            listBuilder.add(repository);
                        }
                        return listBuilder.build();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
