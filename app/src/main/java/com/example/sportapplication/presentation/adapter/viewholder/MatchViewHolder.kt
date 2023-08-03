package com.example.sportapplication.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sportapplication.R
import com.example.sportapplication.databinding.MatchItemBinding
import com.example.sportapplication.domain.entity.Match

class MatchViewHolder(private val binding: MatchItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun onBind(match: Match){
        binding.apply {
            league.text = match.leagueName
            round.text = match.matchRound
            homeTeamName.text = match.matchHometeamName
            awayTeamName.text = match.matchAwayteamName
            homeTeamScore.text = match.matchHometeamScore.toString()
            awayTeamScore.text = match.matchAwayteamScore.toString()
            stadium.text = match.matchStadium
            status.text = match.matchStatus.ifBlank { "Not started" }
            date.text = match.matchDate
            time.text = match.matchTime
            homeTeamImage.load(match.teamHomeBadgeUri){
                error(R.drawable.ic_no_image)
            }
            awayTeamImage.load(match.teamAwayBadgeUri){
                error(R.drawable.ic_no_image)
            }
        }
    }
}