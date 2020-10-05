package a.room.with.a.view.room.dao

import a.room.with.a.view.room.entity.SearchEntity
import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SearchDao {
    @Query("SELECT * FROM search WHERE queryString = :query")
    suspend fun getForQuery(query: String): List<SearchEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(searchResult : List<SearchEntity>)

    @Query("DELETE FROM search")
    fun nukeTable()
}