package com.huangjie.weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.huangjie.weather.R
import com.huangjie.weather.data.City
import com.huangjie.weather.databinding.ListItemCityBinding
import com.huangjie.weather.utils.LogUtils

class CityAdapter : ListAdapter<City, CityAdapter.ViewHolder>(CityDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context)
                , R.layout.list_item_city, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private  val binding: ListItemCityBinding)
        : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                LogUtils.error(it.toString())
            }
        }

        fun bind(item: City) {
            binding.apply{
                city=item
            }
        }
    }
}

private class CityDiffCallback : DiffUtil.ItemCallback<City>() {
    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem.cityId == newItem.cityId
    }

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem == newItem
    }

}