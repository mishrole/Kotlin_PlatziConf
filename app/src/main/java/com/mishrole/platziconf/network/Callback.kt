package com.mishrole.platziconf.network

import java.lang.Exception

interface Callback<T> {
    fun <T> onSuccess(result : T?)
    fun onFailed(exception: Exception)
}