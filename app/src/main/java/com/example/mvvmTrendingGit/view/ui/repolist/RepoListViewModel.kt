package com.example.mvvmTrendingGit.view.ui.repolist

import androidx.lifecycle.MutableLiveData
import com.example.mvvmTrendingGit.model.Item
import com.example.mvvmTrendingGit.model.RepoRepository
import com.example.mvvmTrendingGit.view.base.BaseViewModel

class RepoListViewModel: BaseViewModel() {
    val repoListLive = MutableLiveData<List<Item>>()

    fun fetchRepoList() {
        dataLoading.value = true
        RepoRepository.getInstance().getRepoList { isSuccess, response ->
            dataLoading.value = false
            when {
                isSuccess -> {
                    repoListLive.value = response?.items
                    empty.value = false
                }
                else -> {
                    empty.value = true
                }
            }
        }
    }
}