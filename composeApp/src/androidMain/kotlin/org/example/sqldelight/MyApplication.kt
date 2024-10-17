package org.example.sqldelight

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {
            androidContext(this@MyApplication)

            // Create and inject platform-specific driver
            modules(module {
                single { SampleDatabaseDriverFac(androidContext()).createDriver() }
            }, sharedModule)
        }
    }
}