package ru.ivanova.githubclient.ui.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Irina Ivanova on 11.06.2016.
 */

public interface RepositoriesListViewHolderFactory {
    RecyclerView.ViewHolder createViewHolder(ViewGroup parent);
}
