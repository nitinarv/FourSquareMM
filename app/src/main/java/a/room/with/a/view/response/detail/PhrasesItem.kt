package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class PhrasesItem(@SerializedName("phrase")
                       val phrase: String? = "",
                       @SerializedName("count")
                       val count: Int? = 0,
                       @SerializedName("sample")
                       val sample: Sample?)