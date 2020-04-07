package com.ayon.marvel.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Data Access Object for the comics table.
 */
@Dao
interface ComicsDao {

    /**
     * Get all comics

     * @return all comics in the database
     */
    @Query("SELECT * FROM comics")
    fun getComics(): Observable<List<ComicEntity>>

    /**
     * Insert a user in the database. If the user already exists, replace it.

     * @param user the user to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComics(comic: List<ComicEntity>): Completable

    /**
     * Delete all comics.
     */
    @Query("DELETE FROM comics")
    fun deleteAllComics(): Completable
}
