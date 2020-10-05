package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class DetailsResponse(@SerializedName("meta")
                           val meta: Meta?,
                           @SerializedName("response")
                           val response: Response?)