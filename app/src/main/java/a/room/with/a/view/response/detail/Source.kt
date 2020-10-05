package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Source(@SerializedName("name")
                  val name: String? = "",
                  @SerializedName("url")
                  val url: String? = "")