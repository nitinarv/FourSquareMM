package a.room.with.a.view.response.list

import com.google.gson.annotations.SerializedName

data class Geocode(@SerializedName("what")
                   val what: String? = "",
                   @SerializedName("feature")
                   val feature: Feature?,
                   @SerializedName("where")
                   val where: String? = "")