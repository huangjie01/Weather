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

     var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context)
                , R.layout.list_item_city, parent, false
            ), itemClickListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ListItemCityBinding,
        itemClickListener: ItemClickListener?
    ) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                itemClickListener?.click(binding.city)
            }
        }

        fun bind(item: City) {
            LogUtils.error(item.cityName)
            binding.apply {
                city = item
            }
        }
    }

    interface ItemClickListener {
        fun click(city: City?)
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