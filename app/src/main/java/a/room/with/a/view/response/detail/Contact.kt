package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Contact(@SerializedName("twitter")
                   val twitter: String? = "",
                   @SerializedName("phone")
                   val phone: String? = "",
                   @SerializedName("facebookUsername")
                   val facebookUsername: String? = "",
                   @SerializedName("facebook")
                   val facebook: String? = "",
                   @SerializedName("formattedPhone")
                   val formattedPhone: String? = "",
                   @SerializedName("instagram")
                   val instagram: String? = "",
                   @SerializedName("facebookName")
                   val facebookName: String? = "")