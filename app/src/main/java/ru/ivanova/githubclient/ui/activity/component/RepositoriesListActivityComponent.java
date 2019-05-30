package ru.ivanova.githubclient.ui.activity.component;

import dagger.Subcomponent;
import ru.ivanova.githubclient.ui.activity.ActivityScope;
import ru.ivanova.githubclient.ui.activity.RepositoriesListActivity;
import ru.ivanova.githubclient.ui.activity.module.RepositoriesListActivityModule;

/**
 * Created by Irina Ivanova on 23.04.19.
 */
@ActivityScope
@Subcomponent(
        modules = RepositoriesListActivityModule.class
)
public interface RepositoriesListActivityComponent {

    RepositoriesListActivity inject(RepositoriesListActivity repositoriesListActivity);

}