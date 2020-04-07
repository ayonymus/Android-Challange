package com.ayon.marvel.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ayon.marvel.domain.model.Comic
import java.util.UUID

@Entity(tableName = "comics")
data class ComicEntity(@PrimaryKey
                       @ColumnInfo(name = "comicId")
                       val id: String = UUID.randomUUID().toString(),
                       @ColumnInfo(name = "title")
                       val title: String,
                       @ColumnInfo(name = "description")
                       val description: String?,
                       @ColumnInfo(name = "thumbnail")
                       val thumbnail: String) {

    fun toComic() = Comic(title, description, thumbnail)

    companion object {

        fun fromComic(comic: Comic) =
            ComicEntity(
                title = comic.title,
                description = comic.description, thumbnail = comic.thumbnail
            )
    }
}
