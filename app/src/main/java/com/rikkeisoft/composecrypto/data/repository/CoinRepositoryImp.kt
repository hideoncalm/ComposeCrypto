package com.rikkeisoft.composecrypto.data.repository

import com.rikkeisoft.composecrypto.data.remote.CoinPaprikaApi
import com.rikkeisoft.composecrypto.data.remote.dto.CoinDetailDto
import com.rikkeisoft.composecrypto.data.remote.dto.CoinDto
import com.rikkeisoft.composecrypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}