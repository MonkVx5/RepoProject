package com.example.adrianmatuszewski.repoproject.View.adapter;




import com.example.adrianmatuszewski.repoproject.Model.dataBaseModel.Repo;
import com.example.adrianmatuszewski.repoproject.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Adapter for list of repo
 * author: Adrian Matuszewski
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RepoViewHolder> {

    private final int mItemLayout;
    private final Context mContext;
    private List<Repo> mAdapterListOfRepo;

    public RecyclerAdapter(final Context context, final List<Repo> repo, final int itemLayout) {
        mContext = context;
        mAdapterListOfRepo = repo;
        mItemLayout = itemLayout;
    }


    @Override
    public RepoViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(mItemLayout, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RepoViewHolder holder, final int position) {
        final Repo repo = mAdapterListOfRepo.get(position);
        holder.mName.setText(repo.getName());
        holder.mDescription.setText(repo.getDescription());
        holder.mLanguage.setText(repo.getLanguage());
        holder.mStars.setText(String.valueOf(repo.getStarGazersCount()));
        holder.mUpdate.setText(repo.getUpdatedAt());
    }
    
    
    public void animateTo(final List<Repo> repo) {
        applyAndAnimateRemovals(repo);
        applyAndAnimateAdditions(repo);
        applyAndAnimateMovedItems(repo);
        
    }


    
    private void applyAndAnimateRemovals(final List<Repo> repo) {
        for (int i = mAdapterListOfRepo.size() - 1; i >= 0; i--) {
            final Repo currentRepo = mAdapterListOfRepo.get(i);
            if(!repo.contains(currentRepo)) {
                removeItem(i);
            }
        }
    }
    
    private void applyAndAnimateAdditions(final List<Repo> listOfNewRepo) {
        for (int i = 0, b = listOfNewRepo.size(); i < b; i++) { // todo remove b
            final Repo newRepo = listOfNewRepo.get(i);
            if(!mAdapterListOfRepo.contains(newRepo)) { // +1 :)
                addItem(i, newRepo);
            }
        }
    }
    
    private void applyAndAnimateMovedItems(final List<Repo> repo) {
        for (int toPosition = repo.size() - 1; toPosition >= 0; toPosition--) {
            final Repo currentRepo = repo.get(toPosition);
            final int fromPosition = mAdapterListOfRepo.indexOf(currentRepo);
            if(fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
                
            }
        }
    }
    
    public Repo removeItem(final int position) {
        final Repo model = mAdapterListOfRepo.remove(position);
        notifyItemRemoved(position);
        return model;
    }
    
    public void addItem(final int position, final Repo model) {
        mAdapterListOfRepo.add(position, model);
        notifyItemInserted(position);
    }
    
    public void moveItem(final int fromPosition, final int toPosition) {
        final Repo model = mAdapterListOfRepo.remove(fromPosition);
        mAdapterListOfRepo.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public int getItemCount() {
        return mAdapterListOfRepo.size();
    }

    static class RepoViewHolder extends RecyclerView.ViewHolder {
         public TextView mName;
         public TextView mDescription;
         public TextView mLanguage;
         public TextView mStars;
         public TextView mUpdate;


        public RepoViewHolder(final View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.repo_name);
            mDescription =(TextView) itemView.findViewById(R.id.repo_description);
            mLanguage = (TextView) itemView.findViewById(R.id.repo_language);
            mStars = (TextView) itemView.findViewById(R.id.repo_stars);
            mUpdate = (TextView) itemView.findViewById(R.id.repo_update);

        }

    }

}
