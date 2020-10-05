package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Info(@SerializedName("summary")
                   val summary: String? = "",
                @SerializedName("count")
                   val count: Int? = 0,
                @SerializedName("groups")
                   val groups: List<GroupsItem>?)