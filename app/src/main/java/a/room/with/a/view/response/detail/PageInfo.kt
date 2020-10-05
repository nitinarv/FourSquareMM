package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class PageInfo(@SerializedName("description")
                    val description: String? = "",
                    @SerializedName("banner")
                    val banner: String? = "",
                    @SerializedName("links")
                    val links: Links?)