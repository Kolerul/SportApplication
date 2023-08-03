package com.example.sportapplication.domain.entity

data class Goalscorer(
    val time: String,
    val isHome: Boolean,
    val scorer: String,
    val scorerId: Long,
    val assistant: String,
    val assistantId: Long,
    val score: String,
    val info: String,
    val scoreInfoTime: String
)