package a.room.with.a.view.response.list

import com.google.gson.annotations.SerializedName

data class Response(@SerializedName("geocode")
                    val geocode: Geocode?,
                    @SerializedName("venues")
                    val venues: List<VenuesItem>?)