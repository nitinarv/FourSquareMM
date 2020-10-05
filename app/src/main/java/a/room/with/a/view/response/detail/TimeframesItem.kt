package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class TimeframesItem(@SerializedName("includesToday")
                          val includesToday: Boolean? = false,
                          @SerializedName("days")
                          val days: String? = "",
                          @SerializedName("open")
                          val open: List<OpenItem>?)