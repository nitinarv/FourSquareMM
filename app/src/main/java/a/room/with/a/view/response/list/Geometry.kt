package a.room.with.a.view.response.list

import com.google.gson.annotations.SerializedName

data class Geometry(@SerializedName("center")
                    val center: Center?,
                    @SerializedName("bounds")
                    val bounds: Bounds?)