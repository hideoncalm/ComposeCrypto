package com.rikkeisoft.composecrypto.domain.repository

import com.rikkeisoft.composecrypto.data.remote.dto.CoinDetailDto
import com.rikkeisoft.composecrypto.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto

}