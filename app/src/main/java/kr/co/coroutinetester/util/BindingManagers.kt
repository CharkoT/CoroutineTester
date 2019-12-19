package kr.co.coroutinetester.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.co.coroutinetester.api.model.MainModel
import kr.co.coroutinetester.ui.main.adapter.MainAdapter

object BindingManagers {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context).load(url).into(imageView)
    }

    // 해당 클레스 내부에서 관리하는것이 나을지... 아니면 별도로 관리하는것이 나을지.. 의문..
    @JvmStatic
    @BindingAdapter("items")
    fun setBindItem(view: RecyclerView, items: MutableLiveData<ArrayList<MainModel>>) {
        view.adapter?.run {
            if (this is MainAdapter) {
                this.items = items.value!!
                this.notifyDataSetChanged()
            }
        }
    }

    @JvmStatic
    @BindingConversion
    fun double2String(number: Double): String = "$number"
}