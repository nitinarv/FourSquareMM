package a.room.with.a.view.response

import a.room.with.a.view.repository.source.FSInMemoryDataSource
import a.room.with.a.view.repository.source.FSRemoteDataSource
import a.room.with.a.view.repository.source.FSRoomDataSource
import a.room.with.a.view.room.entity.DetailEntity
import a.room.with.a.view.room.entity.SearchEntity
import a.room.with.a.view.util.Resource
import a.room.with.a.view.util.performGetOperation
import androidx.lifecycle.LiveData
import javax.inject.Inject


class FourSquareRepository @Inject constructor(
    private val roomDataSource: FSRoomDataSource,
    private val inMemoryDataSource: FSInMemoryDataSource,
    private val remoteDataSource: FSRemoteDataSource
) {

    fun searchWithQuery(query: String, emit: (Resource<List<SearchEntity>>) -> Unit) {
        performGetOperation(
            networkCall = { remoteDataSource.search(query) },
            databaseQuery = { roomDataSource.search(query) },
            databaseSave = { roomDataSource.searchDao.insertAll(it)},
            inMemoryGet = { inMemoryDataSource.search(query)},
            inMemorySave = { inMemoryDataSource.saveSearch(it)},
            isNotEmpty = { it?.isNotEmpty() == true },
            emit
        )
    }

    fun detailsWithVenueId(venuId: String, emit: (Resource<DetailEntity>) -> Unit) {
        return performGetOperation(
            networkCall = { remoteDataSource.getVenuDetail(venuId) },
            databaseQuery = { roomDataSource.getVenuDetail(venuId) },
            databaseSave = { roomDataSource.detailDao.insertAll(it) },
            inMemoryGet = { inMemoryDataSource.getVenuDetail(venuId)},
            inMemorySave = { inMemoryDataSource.saveDetails(it) },
            isNotEmpty = { it?.venueId?.isNotEmpty() == true },
            emit
        )
    }

}