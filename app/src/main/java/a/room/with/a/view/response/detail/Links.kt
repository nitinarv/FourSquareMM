package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Links(@SerializedName("count")
                 val count: Int? = 0,
                 @SerializedName("items")
                 val items: List<ItemsItem>?)