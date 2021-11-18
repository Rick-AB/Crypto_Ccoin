package com.example.cryptoccoin.domain.use_case.get_coin

import com.example.cryptoccoin.common.Resource
import com.example.cryptoccoin.domain.models.Coin
import com.example.cryptoccoin.domain.models.CoinDetail
import com.example.cryptoccoin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())

            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Could not reach server. Please check your internet connection"))
        }

    }
}