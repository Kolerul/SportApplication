package com.example.sportapplication.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sportapplication.R
import com.example.sportapplication.databinding.PlayerItemBinding
import com.example.sportapplication.domain.entity.Player

class PlayerViewHolder(private val binding: PlayerItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(player: Player) {
        binding.apply {
            image.load(player.playerImageUri) {
                placeholder(R.drawable.loading_animation)
                error(R.drawable.ic_no_image)
            }
            name.text = player.playerName
            playerType.text = player.playerType
            playerNumber.text =
                binding.root.context.getString(R.string.number, player.playerNumber.toString())
        }
    }
}