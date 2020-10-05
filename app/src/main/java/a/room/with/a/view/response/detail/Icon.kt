package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Icon(@SerializedName("prefix")
                val prefix: String? = "",
                @SerializedName("suffix")
                val suffix: String? = "")