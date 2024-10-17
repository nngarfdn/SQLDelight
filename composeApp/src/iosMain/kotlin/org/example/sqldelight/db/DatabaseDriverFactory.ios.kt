package org.example.sqldelight.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.SampleDatabase

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver =
        NativeSqliteDriver(SampleDatabase.Schema, "DATABASE_NAME")
}