package com.example.core_repository.unwanted_news

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UnwantedNewsModel::class], version = 1)
abstract class UnwantedNewsDatabase: RoomDatabase() {
    abstract fun unwantedNewsDao(): UnwantedNewsDao
}
