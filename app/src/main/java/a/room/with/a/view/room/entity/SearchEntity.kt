package a.room.with.a.view.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search")
data class SearchEntity(
    val venueId: String?,
    val queryString: String?,
    val venueName: String?,
    val formattedAddress: String?,
    val location: String?,
    val icons: String?
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

data class IconInformation(
    val name: String?,
    val prefix: String?,
    val suffix: String?
)