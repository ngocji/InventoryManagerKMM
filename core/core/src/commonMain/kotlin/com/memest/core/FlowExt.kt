package com.memest.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

suspend fun <T> safeCall(
    context: CoroutineContext = Dispatchers.IO,
    error: (suspend () -> T)? = null,
    action: suspend () -> T
) = withContext(context) {
    try {
        action.invoke()
    } catch (e: Exception) {
        error?.invoke()
    }
}

suspend fun <T> safeCall(
    context: CoroutineContext = Dispatchers.IO,
    error: suspend (throwable: Throwable) -> ResultWrapper<T> = { ResultWrapper.Error(throwable = it) },
    action: suspend () -> T
): ResultWrapper<T> {
    return withContext(context) {
        try {
            val data = action.invoke()
            ResultWrapper.Success(data)
        } catch (throwable: Throwable) {
            error(throwable)
        }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun <T> safeFlow(
    flow: Flow<T>
): Flow<ResultWrapper<T>> =
    flow.mapLatest {
        ResultWrapper.Success(it)
    }
        .catch { ResultWrapper.Error(throwable = it) }