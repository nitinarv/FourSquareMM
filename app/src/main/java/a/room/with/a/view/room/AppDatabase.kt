package a.room.with.a.view.room

import a.room.with.a.view.room.dao.DetailDao
import a.room.with.a.view.room.dao.SearchDao
import a.room.with.a.view.room.entity.DetailEntity
import a.room.with.a.view.room.entity.SearchEntity
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(SearchEntity::class, DetailEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun detailDao(): DetailDao
    abstract fun searchDao(): SearchDao
}