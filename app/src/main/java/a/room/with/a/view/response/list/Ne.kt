package a.room.with.a.view.response.list

import com.google.gson.annotations.SerializedName

data class Ne(@SerializedName("lng")
              val lng: Double? = 0.0,
              @SerializedName("lat")
              val lat: Double? = 0.0)