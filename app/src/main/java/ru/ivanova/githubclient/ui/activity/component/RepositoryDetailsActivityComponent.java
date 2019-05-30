package ru.ivanova.githubclient.ui.activity.component;

import dagger.Subcomponent;
import ru.ivanova.githubclient.ui.activity.ActivityScope;
import ru.ivanova.githubclient.ui.activity.RepositoryDetailsActivity;
import ru.ivanova.githubclient.ui.activity.module.RepositoryDetailsActivityModule;

/**
 * Created by Irina Ivanova on 23.04.19.
 */
@ActivityScope
@Subcomponent(
        modules = RepositoryDetailsActivityModule.class
)
public interface RepositoryDetailsActivityComponent {

    RepositoryDetailsActivity inject(RepositoryDetailsActivity repositoryDetailsActivity);

}