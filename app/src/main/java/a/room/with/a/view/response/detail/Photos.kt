package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Photos(@SerializedName("count")
                  val count: Int? = 0,
                  @SerializedName("groups")
                  val groups: List<GroupsItem>?)