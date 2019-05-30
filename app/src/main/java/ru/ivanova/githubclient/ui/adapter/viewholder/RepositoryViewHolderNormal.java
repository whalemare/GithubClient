package ru.ivanova.githubclient.ui.adapter.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.auto.factory.AutoFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ivanova.githubclient.R;
import ru.ivanova.githubclient.data.model.Repository;

/**
 * Created by Irina Ivanova on 11.06.2016.
 */
@AutoFactory(implementing = RepositoriesListViewHolderFactory.class)
public class RepositoryViewHolderNormal extends RepositoryViewHolder {

    @BindView(R.id.tvName)
    TextView tvName;

    public RepositoryViewHolderNormal(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_normal, parent, false));
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(Repository repository) {
        tvName.setText(repository.name);
    }
}
