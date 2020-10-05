package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Price(@SerializedName("tier")
                 val tier: Int = 0,
                 @SerializedName("currency")
                 val currency: String = "",
                 @SerializedName("message")
                 val message: String = "")