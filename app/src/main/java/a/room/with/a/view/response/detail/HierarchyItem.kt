package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class HierarchyItem(@SerializedName("canonicalUrl")
                         val canonicalUrl: String? = "",
                         @SerializedName("name")
                         val name: String? = "",
                         @SerializedName("id")
                         val id: String? = "",
                         @SerializedName("lang")
                         val lang: String? = "")