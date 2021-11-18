package com.example.cryptoccoin.data.repository

import com.example.cryptoccoin.data.remote.CoinPaprikaApi
import com.example.cryptoccoin.data.remote.dto.CoinDetailDto
import com.example.cryptoccoin.data.remote.dto.CoinDto
import com.example.cryptoccoin.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl
@Inject
constructor(
    private val coinPaprikaApi: CoinPaprikaApi
): CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return coinPaprikaApi.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return coinPaprikaApi.getCoinById(coinId)
    }

}