package org.example.sqldelight

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform