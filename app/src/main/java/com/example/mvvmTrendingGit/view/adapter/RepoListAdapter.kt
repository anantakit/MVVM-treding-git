package com.example.mvvmTrendingGit.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmTrendingGit.databinding.ViewRepoListItemBinding
import com.example.mvvmTrendingGit.model.Item
import com.example.mvvmTrendingGit.view.ui.repolist.RepoListViewModel
import com.example.mvvmTrendingGit.view.adapter.viewHolders.RepoListViewHolder as RepoListViewHolder1

class RepoListAdapter(
    private val repoListViewModel: RepoListViewModel,
    private val context: Context
) : RecyclerView.Adapter<RepoListViewHolder1>() {

    private var repoList = listOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder1 {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewRepoListItemBinding.inflate(inflater, parent, false)
        return RepoListViewHolder1(dataBinding, repoListViewModel, context)
    }

    override fun getItemCount() = repoList.size

    override fun onBindViewHolder(holder: RepoListViewHolder1, position: Int) {
        holder.bindData(repoList[position])
    }

    fun updateRepoList(repoList: List<Item>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }

}