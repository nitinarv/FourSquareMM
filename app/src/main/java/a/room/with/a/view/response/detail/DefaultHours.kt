package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class DefaultHours(@SerializedName("isOpen")
                        val isOpen: Boolean? = false,
                        @SerializedName("timeframes")
                        val timeframes: List<TimeframesItem>??,
                        @SerializedName("richStatus")
                        val richStatus: RichStatus?,
                        @SerializedName("isLocalHoliday")
                        val isLocalHoliday: Boolean? = false,
                        @SerializedName("status")
                        val status: String? = "")