package kr.co.coroutinetester.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import kr.co.coroutinetester.R
import kr.co.coroutinetester.databinding.ItemGitUserBinding
import kr.co.coroutinetester.api.model.MainModel

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>() {
    var items = ArrayList<MainModel>()
        set(value) {
            items.clear()
            items.addAll(value)
        }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemGitUserBinding? = null

        init {
            binding = DataBindingUtil.bind(itemView)
        }

        fun bind(item: MainModel) {
            binding?.setVariable(BR.mainItem, item)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_git_user,
            parent,
            false
        )
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }
}