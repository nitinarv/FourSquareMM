package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Sample(@SerializedName("entities")
                  val entities: List<EntitiesItem>?,
                  @SerializedName("text")
                  val text: String? = "")