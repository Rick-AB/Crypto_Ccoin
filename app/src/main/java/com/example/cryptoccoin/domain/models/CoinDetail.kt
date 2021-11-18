package com.example.cryptoccoin.domain.models

import com.example.cryptoccoin.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val rank: Int,
    val symbol: String,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
