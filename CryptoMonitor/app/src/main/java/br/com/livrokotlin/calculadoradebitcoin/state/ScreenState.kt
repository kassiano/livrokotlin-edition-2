package br.com.livrokotlin.calculadoradebitcoin.state

import br.com.livrokotlin.calculadoradebitcoin.service.Ticker

sealed class ScreenState {
    object Loading: ScreenState()
    data class Success(val data: Ticker): ScreenState()
    data class Error(val exception: Throwable): ScreenState()
}

