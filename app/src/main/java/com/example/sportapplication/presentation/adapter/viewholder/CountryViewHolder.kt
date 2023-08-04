package com.example.sportapplication.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sportapplication.R
import com.example.sportapplication.databinding.SimpleItemBinding
import com.example.sportapplication.domain.entity.Country

class CountryViewHolder(private val binding: SimpleItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun onBind(country: Country){
        binding.apply {
            badgeImage.load(country.countryLogoUri){
                placeholder(R.drawable.loading_animation)
                error(R.drawable.ic_no_image)
            }
            name.text = country.countryName
        }
    }
}