package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("code")
    val code: Int? = 0,
    @SerializedName("requestId")
    val requestId: String? = "",
    @SerializedName("errorType")
    val errorType: String? = "",
    @SerializedName("errorDetail")
    val errorDetail: String? = ""
)