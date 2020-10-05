package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Response(@SerializedName("venue")
                    val venue: Venue?)