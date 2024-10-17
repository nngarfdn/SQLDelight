package org.example.sqldelight.db

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.example.SampleDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class ExampleDataSource(private val db: SampleDatabase) {
    private val queries = db.exampleEntityQueries
    fun insert(id: Long?, name: String) {
        queries.insert(id = id, name = name)
    }
    fun getAll() = queries.getAll().asFlow().mapToList(Dispatchers.IO)
    fun update(id: Long, name: String) {
        queries.update(id = id, name = name)
    }
    fun delete(id: Long) {
        queries.delete(id = id)
    }
}