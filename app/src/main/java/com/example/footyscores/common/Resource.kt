package com.example.footyscores.common

sealed class Resource<T>(val data: T? = null, val message: String? = null, val loading: Boolean = true) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(value: Boolean = true ,data: T? = null) : Resource<T>(data, loading = value)
}