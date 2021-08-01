package com.sergeyjojo.todolisttrain.NetworkService.MatchResponse

data class DraftTiming(
    val active_team: Int,
    val extra_time: Int,
    val hero_id: Int,
    val order: Int,
    val pick: Boolean,
    val player_slot: Int,
    val total_time_taken: Int
)