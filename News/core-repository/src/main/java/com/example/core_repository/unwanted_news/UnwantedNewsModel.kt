package com.example.core_repository.unwanted_news

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UnwantedNewsModel (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name="newsName") val newsName: String,
    @ColumnInfo(name="isUnwanted") val isUnwanted: Boolean
)