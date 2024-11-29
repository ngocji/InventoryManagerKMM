package com.memest.inventorymanager

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.memest.datastore.read
import com.memest.datastore.save
import com.memest.inventorymanager.di.appModules
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(appModules)
    }) {
        MaterialTheme {
            val coroutine = rememberCoroutineScope()
            val clickCount by remember {
                read<Int>("click_count", 0)
            }.collectAsState(0)

            Button(onClick = {
                coroutine.launch { save("click_count", clickCount + 1) }
            }, content = { Text("Click me $clickCount") })
        }
    }
}