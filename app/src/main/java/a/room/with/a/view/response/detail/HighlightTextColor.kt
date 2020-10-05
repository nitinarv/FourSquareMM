package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class HighlightTextColor(@SerializedName("photoId")
                              val photoId: String? = "",
                              @SerializedName("value")
                              val value: Int? = 0)