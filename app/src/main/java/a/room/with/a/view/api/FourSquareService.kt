package a.room.with.a.view.api

import a.room.with.a.view.common.RequestConstants
import a.room.with.a.view.response.detail.DetailsResponse
import a.room.with.a.view.response.list.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FourSquareService {
    @GET("search")
    suspend fun getSuspendSearchWithQuery(
        @Query("near") near: String?  = RequestConstants.near,
        @Query("radius") radius: Int?  = RequestConstants.radius,
        @Query("intent") intent: String? = RequestConstants.intent,
        @Query("query") query: String
    ): Response<SearchResponse>

    @GET("{venue_id}")
    suspend fun getSuspendVenuDetails(
        @Path("venue_id") venuId: String
    ): Response<DetailsResponse>
}