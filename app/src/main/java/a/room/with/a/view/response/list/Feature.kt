package a.room.with.a.view.response.list

import com.google.gson.annotations.SerializedName

data class Feature(@SerializedName("cc")
                   val cc: String? = "",
                   @SerializedName("woeType")
                   val woeType: Int? = 0,
                   @SerializedName("highlightedName")
                   val highlightedName: String? = "",
                   @SerializedName("displayName")
                   val displayName: String? = "",
                   @SerializedName("name")
                   val name: String? = "",
                   @SerializedName("geometry")
                   val geometry: Geometry?,
                   @SerializedName("id")
                   val id: String? = "",
                   @SerializedName("longId")
                   val longId: String? = "",
                   @SerializedName("matchedName")
                   val matchedName: String? = "",
                   @SerializedName("slug")
                   val slug: String? = "")