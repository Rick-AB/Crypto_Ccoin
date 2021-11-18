package com.example.cryptoccoin.presentation.coin_list

import com.example.cryptoccoin.domain.models.Coin

data class CoinListState(
    var isLoading: Boolean = false,
    var coins: List<Coin> = emptyList(),
    var error: String = ""
)
