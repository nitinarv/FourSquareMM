package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Stats(@SerializedName("visitsCount")
                 val visitsCount: Int? = 0,
                 @SerializedName("checkinsCount")
                 val checkinsCount: Int? = 0,
                 @SerializedName("usersCount")
                 val usersCount: Int? = 0,
                 @SerializedName("tipCount")
                 val tipCount: Int? = 0)