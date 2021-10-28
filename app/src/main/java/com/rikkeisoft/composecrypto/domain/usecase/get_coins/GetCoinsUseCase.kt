package com.rikkeisoft.composecrypto.domain.usecase.get_coins

import com.rikkeisoft.composecrypto.data.remote.dto.toCoin
import com.rikkeisoft.composecrypto.domain.model.Coin
import com.rikkeisoft.composecrypto.domain.repository.CoinRepository
import com.rikkeisoft.composecrypto.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
        private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (exception: HttpException) {
            emit(Resource.Error(exception.localizedMessage ?: "An unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}