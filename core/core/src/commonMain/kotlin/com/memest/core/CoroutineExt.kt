package com.memest.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

typealias SuspendActionUnit = suspend CoroutineScope.() -> Unit

fun CoroutineScope.runAsync(
    context: CoroutineDispatcher = Dispatchers.IO,
    onComplete: (suspend CoroutineScope.(isCompleted: Boolean) -> Unit)? = null,
    vararg actions: SuspendActionUnit
): Job {
    return launch(context = context) {
        val deferredJobs = actions.map { action ->
            async {
                action()
            }
        }
        var isCompleted = false
        try {
            deferredJobs.awaitAll()
            isCompleted = true
        } catch (_: Exception) {

        } finally {
            if (onComplete != null) onComplete(isCompleted)
        }
    }
}

fun CoroutineScope.runCoroutine(
    context: CoroutineDispatcher = Dispatchers.IO,
    action: SuspendActionUnit
) = launch(context = context) { action() }