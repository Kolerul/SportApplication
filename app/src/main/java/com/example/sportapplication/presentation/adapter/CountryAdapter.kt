package com.example.sportapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.sportapplication.databinding.SimpleItemBinding
import com.example.sportapplication.domain.entity.Country
import com.example.sportapplication.presentation.adapter.viewholder.CountryViewHolder

class CountryAdapter(
    private val onItemClick: (Country) -> Unit
): ListAdapter<Country, CountryViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder =
        CountryViewHolder(
            SimpleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val current = getItem(position)
        holder.onBind(current)
        holder.itemView.setOnClickListener {
            onItemClick(current)
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Country>(){

        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.countryId == newItem.countryId
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.countryName == newItem.countryName
        }
    }
}