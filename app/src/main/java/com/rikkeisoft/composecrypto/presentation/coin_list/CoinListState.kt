package com.rikkeisoft.composecrypto.presentation.coin_list

import com.rikkeisoft.composecrypto.domain.model.Coin

data class CoinListState(
        val isLoading: Boolean = false,
        val coins: List<Coin> = emptyList(),
        val error: String = ""
)