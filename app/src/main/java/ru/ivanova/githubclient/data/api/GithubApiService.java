package ru.ivanova.githubclient.data.api;

import java.util.List;

import ru.ivanova.githubclient.data.api.response.RepositoryResponse;
import ru.ivanova.githubclient.data.api.response.UserResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Irina Ivanova on 22.04.19.
 */
public interface GithubApiService {

    @GET("/users/{username}")
    Observable<UserResponse> getUser(
            @Path("username") String username
    );

    @GET("/users/{username}/repos")
    Observable<List<RepositoryResponse>> getUsersRepositories(
            @Path("username") String username
    );
}
