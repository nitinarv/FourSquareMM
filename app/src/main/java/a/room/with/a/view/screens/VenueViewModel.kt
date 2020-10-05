package a.room.with.a.view.screens

import a.room.with.a.view.response.FourSquareRepository
import a.room.with.a.view.room.entity.DetailEntity
import a.room.with.a.view.room.entity.SearchEntity
import a.room.with.a.view.util.Resource
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class VenueViewModel @ViewModelInject constructor(val fourSquareRepository : FourSquareRepository): ViewModel(){
    var searchResultLiveData = MutableLiveData<Resource<List<SearchEntity>>>()
    var detailsLiveData = MutableLiveData<Resource<DetailEntity>>()

    fun search(query: String) {
        fourSquareRepository.searchWithQuery(query){
            CoroutineScope(Dispatchers.Main).launch { searchResultLiveData.postValue(it) }
        }
    }

    fun details(venueId: String) {
        fourSquareRepository.detailsWithVenueId(venueId) {
            CoroutineScope(Dispatchers.Main).launch { detailsLiveData.postValue(it) }
        }
}

}