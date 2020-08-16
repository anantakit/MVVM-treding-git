package com.example.mvvmTrendingGit.view.ui.repolist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmTrendingGit.R
import com.example.mvvmTrendingGit.databinding.FragmentRepoListBinding
import com.example.mvvmTrendingGit.view.adapter.RepoListAdapter

class RepoListFragment : Fragment(){
    private lateinit var dataBinding: FragmentRepoListBinding
    private lateinit var viewModel: RepoListViewModel
    private lateinit var adater: RepoListAdapter
    private var mContext: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_repo_list, container, false)
        viewModel = ViewModelProvider(this).get(RepoListViewModel::class.java)
        dataBinding.lifecycleOwner = this
        dataBinding.viewModel = viewModel
        return dataBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getRepoList()
        setupObservers()
        setupAdapter()
    }

    private fun setupAdapter() {
        adater = RepoListAdapter(viewModel, context = mContext!!)
        dataBinding.apply {
            repoListRv.apply {
                adapter = adater
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        }
    }

    private fun setupObservers() {
        viewModel.repoListLive.observe(viewLifecycleOwner, Observer {
            adater.updateRepoList(it)
        })

        viewModel.toastMessage.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()
        })
    }

    private fun getRepoList() {
        viewModel.fetchRepoList()
    }
}