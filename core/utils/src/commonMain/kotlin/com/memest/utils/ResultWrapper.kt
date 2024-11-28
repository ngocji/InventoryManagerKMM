package com.memest.utils

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class Error(val code: Int? = null, val error: String? = null) : ResultWrapper<Nothing>()
    data object Empty : ResultWrapper<Nothing>()
    data object Idle : ResultWrapper<Nothing>()
    data object Loading : ResultWrapper<Nothing>()

    fun isSuccess(): Boolean = this is Success<*>
    fun isError(): Boolean = this is Error
    fun isEmpty(): Boolean = this is Empty
    fun isLoading(): Boolean = this is Loading
    fun isIdle(): Boolean = this is Idle

    fun getOrNull(): T? = (this as? Success)?.value

    fun get(): T = (this as Success).value
}