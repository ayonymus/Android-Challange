package com.ayon.marvel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ayon.marvel.data.local.ComicEntity
import com.ayon.marvel.data.local.ComicsDao

@Database(entities = [ComicEntity::class], version = 1)
abstract class ComicsDatabase : RoomDatabase() {

    abstract fun comicsDao(): ComicsDao
}