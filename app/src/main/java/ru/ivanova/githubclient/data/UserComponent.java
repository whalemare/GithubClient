package ru.ivanova.githubclient.data;

import dagger.Subcomponent;
import ru.ivanova.githubclient.data.api.UserModule;
import ru.ivanova.githubclient.ui.activity.component.RepositoriesListActivityComponent;
import ru.ivanova.githubclient.ui.activity.component.RepositoryDetailsActivityComponent;
import ru.ivanova.githubclient.ui.activity.module.RepositoriesListActivityModule;
import ru.ivanova.githubclient.ui.activity.module.RepositoryDetailsActivityModule;

@UserScope
@Subcomponent(
        modules = {
                UserModule.class
        }
)
public interface UserComponent {

    RepositoriesListActivityComponent plus(RepositoriesListActivityModule module);

    RepositoryDetailsActivityComponent plus(RepositoryDetailsActivityModule module);
}