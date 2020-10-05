package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class RichStatus(
    @SerializedName("text")
    val text: String = "")