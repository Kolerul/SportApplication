package com.example.sportapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.sportapplication.databinding.SimpleItemBinding
import com.example.sportapplication.domain.entity.League
import com.example.sportapplication.presentation.adapter.viewholder.LeagueViewHolder

class LeagueAdapter(private val onItemClick: (League) -> Unit): ListAdapter<League, LeagueViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder =
        LeagueViewHolder(
            SimpleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        val current = getItem(position)
        holder.onBind(current)
        holder.itemView.setOnClickListener {
            onItemClick(current)
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<League>(){

        override fun areItemsTheSame(oldItem: League, newItem: League): Boolean {
            return oldItem.leagueId == newItem.leagueId
        }

        override fun areContentsTheSame(oldItem: League, newItem: League): Boolean {
            return oldItem.leagueName == newItem.leagueName
        }
    }

}