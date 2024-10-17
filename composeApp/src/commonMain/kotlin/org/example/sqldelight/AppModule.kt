package org.example.sqldelight

import app.cash.sqldelight.db.SqlDriver
import com.example.SampleDatabase
import org.example.sqldelight.db.DatabaseDriverFactory
import org.example.sqldelight.db.ExampleDataSource
import org.koin.dsl.module

val sharedModule = module {

    // Provide the SampleDatabase instance
    single { SampleDatabase(get()) }

    // Provide ExampleDataSource
    single { ExampleDataSource(get()) }
}