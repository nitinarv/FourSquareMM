package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Location(@SerializedName("cc")
                    val cc: String? = "",
                    @SerializedName("country")
                    val country: String? = "",
                    @SerializedName("labeledLatLngs")
                    val labeledLatLngs: List<LabeledLatLngsItem>?,
                    @SerializedName("address")
                    val address: String? = "",
                    @SerializedName("lng")
                    val lng: Double? = 0.0,
                    @SerializedName("formattedAddress")
                    val formattedAddress: List<String>?,
                    @SerializedName("city")
                    val city: String? = "",
                    @SerializedName("postalCode")
                    val postalCode: String? = "",
                    @SerializedName("neighborhood")
                    val neighborhood: String? = "",
                    @SerializedName("state")
                    val state: String? = "",
                    @SerializedName("crossStreet")
                    val crossStreet: String? = "",
                    @SerializedName("lat")
                    val lat: Double? = 0.0)