package a.room.with.a.view.repository.source

import a.room.with.a.view.room.dao.DetailDao
import a.room.with.a.view.room.dao.SearchDao
import a.room.with.a.view.room.entity.DetailEntity
import a.room.with.a.view.room.entity.SearchEntity
import a.room.with.a.view.util.Resource
import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import javax.inject.Inject

class FSRoomDataSource @Inject constructor(val searchDao: SearchDao,val detailDao: DetailDao){
    suspend fun search(query: String): List<SearchEntity>? {
        return searchDao.getForQuery(query)
    }

    suspend fun getVenuDetail(venuId: String): DetailEntity? {
        return detailDao.getVenuId(venuId)
    }

    suspend fun insertAll(searchResult : List<SearchEntity>){
        searchDao.insertAll(searchResult)
    }

    suspend fun insert(detailEntity: DetailEntity){
        detailDao.insertAll(detailEntity)
    }
}