package com.example.cryptoccoin.presentation.coin_detail

import com.example.cryptoccoin.domain.models.CoinDetail

data class CoinDetailState(
    var isLoading: Boolean = false,
    var coin: CoinDetail? = null,
    var error: String = ""
)
