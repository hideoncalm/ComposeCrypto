package com.rikkeisoft.composecrypto.di

import com.rikkeisoft.composecrypto.data.remote.CoinPaprikaApi
import com.rikkeisoft.composecrypto.data.repository.CoinRepositoryImp
import com.rikkeisoft.composecrypto.domain.repository.CoinRepository
import com.rikkeisoft.composecrypto.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CoinPaprikaApi::class.java)

    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository = CoinRepositoryImp(api)
}