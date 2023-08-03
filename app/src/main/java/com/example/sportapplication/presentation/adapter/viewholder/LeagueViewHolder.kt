package com.example.sportapplication.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sportapplication.R
import com.example.sportapplication.databinding.SimpleItemBinding
import com.example.sportapplication.domain.entity.League

class LeagueViewHolder(private val binding: SimpleItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun onBind(league: League){
        binding.apply {
            badgeImage.load(league.leagueLogoUri){
                error(R.drawable.ic_no_image)
            }
            name.text = league.leagueName
        }
    }
}