package a.room.with.a.view.response.list

import com.google.gson.annotations.SerializedName

data class CategoriesItem(@SerializedName("pluralName")
                          val pluralName: String? = "",
                          @SerializedName("name")
                          val name: String? = "",
                          @SerializedName("icon")
                          val icon: Icon?,
                          @SerializedName("id")
                          val id: String? = "",
                          @SerializedName("shortName")
                          val shortName: String? = "",
                          @SerializedName("primary")
                          val primary: Boolean? = false)