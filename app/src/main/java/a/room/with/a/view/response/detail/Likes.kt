package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Likes(@SerializedName("summary")
                 val summary: String? = "",
                 @SerializedName("count")
                 val count: Int? = 0)