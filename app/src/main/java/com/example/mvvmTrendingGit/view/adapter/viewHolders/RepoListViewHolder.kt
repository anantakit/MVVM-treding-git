package com.example.mvvmTrendingGit.view.adapter.viewHolders



import android.R
import android.content.Context
import android.graphics.drawable.PictureDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mvvmTrendingGit.databinding.ViewRepoListItemBinding
import com.example.mvvmTrendingGit.model.Item
import com.example.mvvmTrendingGit.view.ui.repolist.RepoListViewModel


class RepoListViewHolder(
    private val dataBinding: ViewRepoListItemBinding,
    private val repoListViewModel: RepoListViewModel,
    private val context: Context
): RecyclerView.ViewHolder(dataBinding.root) {

    fun bindData(item: Item) {
        dataBinding.apply {
            itemData = item
            Glide.with(context).load(item.owner.avatar_url).into(itemAvatar)
//            root.setOnClickListener {
//
//            }

//
//            itemView.onClick {
//                val bundle = bundleOf("url" to itemData.html_url)
//                itemView.findNavController().navigate(R.id.action_repoListFragment_to_repoDetailFragment, bundle)
//            }
        }
    }
}