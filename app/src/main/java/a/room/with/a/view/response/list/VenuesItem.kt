package a.room.with.a.view.response.list

import com.google.gson.annotations.SerializedName

data class VenuesItem(@SerializedName("venuePage")
                      val venuePage: VenuePage?,
                      @SerializedName("hasPerk")
                      val hasPerk: Boolean? = false,
                      @SerializedName("referralId")
                      val referralId: String? = "",
                      @SerializedName("name")
                      val name: String? = "",
                      @SerializedName("location")
                      val location: Location?,
                      @SerializedName("id")
                      val id: String? = "",
                      @SerializedName("categories")
                      val categories: List<CategoriesItem>?)