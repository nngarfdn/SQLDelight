package org.example.sqldelight

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.SampleDatabase


actual class SampleDatabaseDriverFac  {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(SampleDatabase.Schema, "sample.db")
    }
}