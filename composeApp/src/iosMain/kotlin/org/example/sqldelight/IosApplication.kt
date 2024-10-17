package org.example.sqldelight

import org.koin.core.context.startKoin

fun iosInitKoin() {
    startKoin {
        modules(sharedModule, iosModule)
    }
}
