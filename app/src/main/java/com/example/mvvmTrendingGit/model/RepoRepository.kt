package com.example.mvvmTrendingGit.model

import com.example.mvvmTrendingGit.model.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoRepository {
    fun getRepoList(onResult: (isSuccess: Boolean, response: GitResponse?) -> Unit) {
        ApiClient.instance.getRepo().enqueue(object : Callback<GitResponse> {
            override fun onFailure(call: Call<GitResponse>, t: Throwable) {
                onResult(false, null)
            }

            override fun onResponse(call: Call<GitResponse>, response: Response<GitResponse>) {
                if (response.isSuccessful)
                    onResult(true, response.body())
                else
                    onResult(false, null)
            }

        })
    }

    companion object {
        private var INSTANCE: RepoRepository? = null
        fun getInstance() = INSTANCE ?: RepoRepository().also {
            INSTANCE = it
        }
    }
}