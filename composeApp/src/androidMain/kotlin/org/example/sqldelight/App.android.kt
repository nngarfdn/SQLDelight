package org.example.sqldelight

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.SampleDatabase


actual class SampleDatabaseDriverFac(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(SampleDatabase.Schema, context, "sample.db")
    }
}