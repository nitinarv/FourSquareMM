package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Parent(@SerializedName("name")
                  val name: String? = "",
                  @SerializedName("location")
                  val location: Location?,
                  @SerializedName("id")
                  val id: String? = "",
                  @SerializedName("categories")
                  val categories: List<CategoriesItem>??)