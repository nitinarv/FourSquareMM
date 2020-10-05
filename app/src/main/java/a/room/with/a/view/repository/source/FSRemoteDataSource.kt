package a.room.with.a.view.repository.source


import a.room.with.a.view.api.FourSquareService
import a.room.with.a.view.repository.utils.Convert
import a.room.with.a.view.util.BaseDataSource
import javax.inject.Inject

class FSRemoteDataSource @Inject constructor(
    private val fourSquareService: FourSquareService
) : BaseDataSource() {

    suspend fun search(query: String) =
        getResultWithCast(call = {
            fourSquareService.getSuspendSearchWithQuery(query = query)
        } , transformer = {
            Convert.searchResponseToListSearchEntity(
                query = query,
                response = it
            )
        })

    suspend fun getVenuDetail(venuId: String) =
        getResultWithCast(call = {
            fourSquareService.getSuspendVenuDetails(venuId)
        }, transformer = {
            Convert.detailsResponseToDetailsEntity(response = it)
        })
}