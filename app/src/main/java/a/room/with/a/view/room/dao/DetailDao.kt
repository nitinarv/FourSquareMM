package a.room.with.a.view.room.dao

import a.room.with.a.view.room.entity.DetailEntity
import a.room.with.a.view.room.entity.SearchEntity
import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DetailDao{
    @Query("SELECT * FROM details WHERE venueId = :venuId")
    suspend fun getVenuId(venuId: String): DetailEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg detail: DetailEntity)

    @Query("DELETE FROM details")
    fun nukeTable()
}