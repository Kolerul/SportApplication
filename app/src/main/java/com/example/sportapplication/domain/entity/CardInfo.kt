package com.example.sportapplication.domain.entity


data class CardInfo(
    val time: String,
    val card: Card,
    val isHomeFault: Boolean,
    val info: String,
    val playerId: Long,
    val scoreInfoTime: String
)
