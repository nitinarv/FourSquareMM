package a.room.with.a.view.repository.source

import a.room.with.a.view.room.entity.DetailEntity
import a.room.with.a.view.room.entity.SearchEntity
import androidx.collection.LruCache
import javax.inject.Inject

class FSInMemoryDataSource @Inject constructor() {
    private val searchCache = LruCache<String, List<SearchEntity>>(7)
    private val detailsCache = LruCache<String, DetailEntity>(21)

    fun search(query: String): List<SearchEntity>? {
        return searchCache.get(query)
    }

    fun getVenuDetail(venuId: String): DetailEntity? {
        return detailsCache.get(venuId)
    }

    suspend fun saveSearch(searchResult: List<SearchEntity>) {
        searchResult?.getOrNull(0)?.queryString?.let { query ->
            searchCache.put(query, searchResult)
        }
    }

    suspend fun saveDetails(details: DetailEntity) {
        detailsCache.put(details.venueId, details)
    }
}