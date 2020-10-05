package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class BeenHere(@SerializedName("marked")
                    val marked: Boolean? = false,
                    @SerializedName("count")
                    val count: Int? = 0,
                    @SerializedName("unconfirmedCount")
                    val unconfirmedCount: Int? = 0,
                    @SerializedName("lastCheckinExpiredAt")
                    val lastCheckinExpiredAt: Int? = 0)