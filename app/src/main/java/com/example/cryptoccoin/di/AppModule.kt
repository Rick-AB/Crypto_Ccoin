package com.example.cryptoccoin.di

import com.example.cryptoccoin.data.repository.CoinRepositoryImpl
import com.example.cryptoccoin.data.remote.CoinPaprikaApi
import com.example.cryptoccoin.common.Constants.COINPAPRIKA_BASE_URL
import com.example.cryptoccoin.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): CoinPaprikaApi {
        return Retrofit.Builder().baseUrl(COINPAPRIKA_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        coinPaprikaApi: CoinPaprikaApi
    ): CoinRepository = CoinRepositoryImpl(coinPaprikaApi)
}