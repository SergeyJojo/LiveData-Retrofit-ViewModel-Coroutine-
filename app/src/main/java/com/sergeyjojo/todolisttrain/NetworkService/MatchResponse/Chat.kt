package com.sergeyjojo.todolisttrain.NetworkService.MatchResponse

data class Chat(
    val key: String,
    val player_slot: Int,
    val slot: Int,
    val time: Int,
    val unit: String
)