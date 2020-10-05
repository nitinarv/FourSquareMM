package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class ItemsItem(
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("displayValue")
    val displayValue: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("createdAt")
    val createdAt: Int = 0,
    @SerializedName("visibility")
    val visibility: String = "",
    @SerializedName("prefix")
    val prefix: String = "",
    @SerializedName("width")
    val width: Int = 0,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("source")
    val source: Source,
    @SerializedName("suffix")
    val suffix: String = "",
    @SerializedName("user")
    val user: User,
    @SerializedName("height")
    val height: Int = 0

)