package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Colors(@SerializedName("highlightColor")
                  val highlightColor: HighlightColor,
                  @SerializedName("algoVersion")
                  val algoVersion: Int = 0,
                  @SerializedName("highlightTextColor")
                  val highlightTextColor: HighlightTextColor
)