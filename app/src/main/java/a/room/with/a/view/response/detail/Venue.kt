package a.room.with.a.view.response.detail

import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("parent")
    val parent: Parent?,
    @SerializedName("reasons")
    val reasons: Reasons?,
    @SerializedName("specials")
    val specials: Info?,
    @SerializedName("dislike")
    val dislike: Boolean? = false,
    @SerializedName("shortUrl")
    val shortUrl: String? = "",
    @SerializedName("rating")
    val rating: Double? = 0.0,
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("photos")
    val photos: Photos?,
    @SerializedName("tips")
    val tips: Info?,
    @SerializedName("colors")
    val colors: Colors?,
    @SerializedName("hereNow")
    val hereNow: Info?,
    @SerializedName("createdAt")
    val createdAt: Int? = 0,
    @SerializedName("stats")
    val stats: Stats?,
    @SerializedName("contact")
    val contact: Contact?,
    @SerializedName("ratingColor")
    val ratingColor: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("categories")
    val categories: List<CategoriesItem>?,
    @SerializedName("ok")
    val ok: Boolean? = false,
    @SerializedName("allowMenuUrlEdit")
    val allowMenuUrlEdit: Boolean? = false,
    @SerializedName("popular")
    val popular: Popular?,
    @SerializedName("likes")
    val likes: Likes?,
    @SerializedName("hours")
    val hours: Hours?,
    @SerializedName("canonicalUrl")
    val canonicalUrl: String? = "",
    @SerializedName("hierarchy")
    val hierarchy: List<HierarchyItem>?,
    @SerializedName("verified")
    val verified: Boolean? = false,
    @SerializedName("timeZone")
    val timeZone: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("beenHere")
    val beenHere: BeenHere?,
    @SerializedName("bestPhoto")
    val bestPhoto: BestPhoto?,
    @SerializedName("ratingSignals")
    val ratingSignals: Int? = 0,
    @SerializedName("listed")
    val listed: Info?,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("defaultHours")
    val defaultHours: DefaultHours?,
    @SerializedName("location")
    val location: Location?,
    @SerializedName("attributes")
    val attributes: Info?,
    @SerializedName("pageUpdates")
    val pageUpdates: Info?,
    @SerializedName("inbox")
    val inbox: Info?,
    @SerializedName("price")
    val price: Price?,
    @SerializedName("storeId")
    val storeId: String? = "",
    @SerializedName("page")
    val page: Page?,
    @SerializedName("phrases")
    val phrases: List<PhrasesItem>?
)