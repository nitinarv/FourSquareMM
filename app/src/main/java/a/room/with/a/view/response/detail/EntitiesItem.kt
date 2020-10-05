package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class EntitiesItem(@SerializedName("indices")
                        val indices: List<Integer>?,
                        @SerializedName("type")
                        val type: String? = "")