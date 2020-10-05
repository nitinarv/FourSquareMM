package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class LabeledLatLngsItem(@SerializedName("lng")
                              val lng: Double? = 0.0,
                              @SerializedName("label")
                              val label: String? = "",
                              @SerializedName("lat")
                              val lat: Double? = 0.0)