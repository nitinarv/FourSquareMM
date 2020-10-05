package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Lists(@SerializedName("groups")
                 val groups: List<GroupsItem>?)