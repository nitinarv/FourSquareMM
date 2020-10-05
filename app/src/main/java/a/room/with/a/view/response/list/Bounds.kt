package a.room.with.a.view.response.list

import com.google.gson.annotations.SerializedName

data class Bounds(@SerializedName("sw")
                  val sw: Sw?,
                  @SerializedName("ne")
                  val ne: Ne?)