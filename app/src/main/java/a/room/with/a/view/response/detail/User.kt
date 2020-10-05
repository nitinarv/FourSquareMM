package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("firstName")
                val firstName: String? = "",
                @SerializedName("lists")
                val lists: Lists?,
                @SerializedName("photo")
                val photo: Photo?,
                @SerializedName("bio")
                val bio: String? = "",
                @SerializedName("id")
                val id: String? = "",
                @SerializedName("type")
                val type: String? = "",
                @SerializedName("tips")
                val tips: Info?)