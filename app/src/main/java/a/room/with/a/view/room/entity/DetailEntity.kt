package a.room.with.a.view.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "details")
data class DetailEntity(
    @PrimaryKey
    @ColumnInfo(name = "venueId")
    val venueId: String,
    val venueName: String?,
    val likes: Int?,
    val description: String?,
    val shortUrl: String?,
    val photos: String?,
    val ratings: Double?,
    val hours: String?,
    val errorMessage: String?
)

data class PhotoInfo(
    val prefix: String?,
    val suffix: String?,
    val name: String?,
)
