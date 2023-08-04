package com.example.sportapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.sportapplication.databinding.MatchItemBinding
import com.example.sportapplication.domain.entity.Match
import com.example.sportapplication.presentation.adapter.viewholder.MatchViewHolder

class MatchesAdapter(private val onImageClickListener: (Int) -> Unit) :
    ListAdapter<Match, MatchViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder =
        MatchViewHolder(
            MatchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val current = getItem(position)
        holder.onBind(current, onImageClickListener)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Match>(){

        override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem.matchId == newItem.matchId
        }

        override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
            return (oldItem.matchHometeamScore + oldItem.matchAwayteamScore) ==
                    (newItem.matchHometeamScore + newItem.matchAwayteamScore)
        }

    }
}