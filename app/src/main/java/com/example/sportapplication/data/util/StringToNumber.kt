package com.example.sportapplication.data.util

fun String.toIntOrZero() =
    if (this.isNotBlank()){
        this.toInt()
    }else{
        0
    }

fun String.toIntOrNull() =
    if (this.isNotBlank()){
        this.toInt()
    }else{
        null
    }

fun String.toLongOrZero() =
    if (this.isNotBlank()){
        this.toLong()
    }else{
        0
    }

fun String.toLongOrNull() =
    if (this.isNotBlank()){
        this.toLong()
    }else{
        null
    }