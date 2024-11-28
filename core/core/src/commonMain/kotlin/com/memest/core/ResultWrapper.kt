package com.memest.core

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class Error(
        val code: Int? = null,
        val error: String? = null,
        val throwable: Throwable? = null
    ) : ResultWrapper<Nothing>()

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

inline fun <T> ResultWrapper<T>.applyWhenSuccess(action: (value: T) -> Unit): ResultWrapper<T> {
    if (this.isSuccess()) {
        action.invoke(this.getOrNull() ?: return this)
    }
    return this
}

inline fun <T, R> ResultWrapper<T>.mapWhenSuccess(action: (value: T) -> R): ResultWrapper<R> {
    return when (this) {
        is ResultWrapper.Loading -> ResultWrapper.Loading
        is ResultWrapper.Error -> ResultWrapper.Error(
            code = this.code,
            error = this.error,
            throwable = this.throwable
        )

        is ResultWrapper.Success -> ResultWrapper.Success(
            action(
                value ?: throw IllegalArgumentException("Data is null")
            )
        )

        else -> ResultWrapper.Idle
    }
}