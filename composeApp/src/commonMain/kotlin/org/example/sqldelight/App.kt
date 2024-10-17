package org.example.sqldelight

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.cash.sqldelight.db.SqlDriver
import com.example.ExampleEntity
import com.example.SampleDatabase
import kotlinx.coroutines.launch
import org.example.sqldelight.db.ExampleDataSource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.getKoin
import sqldelight.composeapp.generated.resources.Res
import sqldelight.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }

        //instance SampleDatabaseDriverFac

        val db: SampleDatabase = getKoin().get()  // Getting SampleDatabase instance
        val exampleDataSource: ExampleDataSource = getKoin().get()  // G

        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ExampleDataSourceScreen(db)
        }
    }
}


expect class SampleDatabaseDriverFac {
    fun createDriver(): SqlDriver
}

@Composable
fun ExampleDataSourceScreen(db: SampleDatabase) {

    val exampleDataSource = ExampleDataSource(db)
    val exampleItems = remember { mutableStateListOf<ExampleEntity>() }
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        exampleDataSource.getAll().collect { items ->
            exampleItems.clear()
            exampleItems.addAll(items)
        }
    }

    Column {
        // Display the list of items from the database
        exampleItems.forEach { item ->
            Text(text = "${item.id}: ${item.name}")
        }

        // Button to insert a new item into the database
        Button(onClick = {
            scope.launch {
                exampleDataSource.insert(null, "New Item")
            }
        }) {
            Text(text = "Insert New Item")
        }

        // Button to update an existing item in the database
        Button(onClick = {
            scope.launch {
                val itemToUpdate = exampleItems.firstOrNull() // Assume first item for this example
                itemToUpdate?.let {
                    exampleDataSource.update(it.id, "Updated Name")
                }
            }
        }) {
            Text(text = "Update First Item")
        }

        // Button to delete an item from the database
        Button(onClick = {
            scope.launch {
                val itemToDelete = exampleItems.firstOrNull() // Assume first item for this example
                itemToDelete?.let {
                    exampleDataSource.delete(it.id)
                }
            }
        }) {
            Text(text = "Delete First Item")
        }
    }
}
