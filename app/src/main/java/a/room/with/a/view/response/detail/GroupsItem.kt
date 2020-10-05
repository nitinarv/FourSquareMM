package a.room.with.a.view.response.detail

import a.room.with.a.view.response.detail.ItemsItem
import com.google.gson.annotations.SerializedName

data class GroupsItem(@SerializedName("summary")
                      val summary: String = "",
                      @SerializedName("name")
                      val name: String = "",
                      @SerializedName("count")
                      val count: Int = 0,
                      @SerializedName("type")
                      val type: String = "",
                      @SerializedName("items")
                      val items: List<ItemsItem>?)