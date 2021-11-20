package com.example.core_repository.unwanted_news

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UnwantedNewsDao {
    @Query("SELECT * FROM UnwantedNewsModel WHERE isUnwanted = 0")
    fun getWantedNews(): Single<UnwantedNewsModel>

    @Update
    fun update(unwantedNews: UnwantedNewsModel): Completable
}