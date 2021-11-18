package com.example.cryptoccoin.domain.repository

import com.example.cryptoccoin.data.remote.dto.CoinDetailDto
import com.example.cryptoccoin.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}