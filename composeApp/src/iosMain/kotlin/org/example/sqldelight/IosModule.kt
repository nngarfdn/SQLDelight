package org.example.sqldelight

import app.cash.sqldelight.db.SqlDriver
import org.koin.dsl.module

val iosModule = module {
    // Create an instance of SampleDatabaseDriverFac and call createDriver
    single<SqlDriver> { SampleDatabaseDriverFac().createDriver() }
}