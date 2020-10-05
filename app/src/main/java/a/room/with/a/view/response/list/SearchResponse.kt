package a.room.with.a.view.response.list

import com.google.gson.annotations.SerializedName

data class SearchResponse(@SerializedName("meta")
                          val meta: Meta?,
                          @SerializedName("response")
                          val response: Response?)