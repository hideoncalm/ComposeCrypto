package com.rikkeisoft.composecrypto.presentation.coin_detail

import com.rikkeisoft.composecrypto.domain.model.CoinDetail

data class CoinDetailState(
        val isLoading: Boolean = false,
        val coin: CoinDetail? = null,
        val error: String = ""
)