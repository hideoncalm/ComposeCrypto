package com.rikkeisoft.composecrypto.domain.usecase.get_coin

import com.rikkeisoft.composecrypto.data.remote.dto.toCoinDetail
import com.rikkeisoft.composecrypto.domain.model.CoinDetail
import com.rikkeisoft.composecrypto.domain.repository.CoinRepository
import com.rikkeisoft.composecrypto.utils.Resource
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
            emit(Resource.Error(e.localizedMessage ?: "An unexpected Error Http Connection"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}