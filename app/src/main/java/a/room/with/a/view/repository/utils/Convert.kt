package a.room.with.a.view.repository.utils

import a.room.with.a.view.response.detail.DetailsResponse
import a.room.with.a.view.response.list.SearchResponse
import a.room.with.a.view.room.entity.DetailEntity
import a.room.with.a.view.room.entity.IconInformation
import a.room.with.a.view.room.entity.PhotoInfo
import a.room.with.a.view.room.entity.SearchEntity
import com.google.gson.Gson

object Convert {

    fun searchResponseToListSearchEntity(query: String, response: SearchResponse) : List<SearchEntity>?{
        return response.response?.venues?.flatMap { venueItem ->
            listOf(
                SearchEntity(
                    queryString = query,
                    venueId = venueItem.id,
                    venueName = venueItem.name,
                    formattedAddress = venueItem.location?.formattedAddress?.run {
                        var fullAdddress = StringBuilder()
                        fullAdddress.apply {
                            forEach { append("$it \n") }
                        }

                        fullAdddress.toString()
                    },
                    location = venueItem.location?.run {
                        var fullLocation = StringBuilder()
                        fullLocation.apply {
                            append("${city ?: ""}")
                            postalCode?.let { append("${postalCode?.run { " ${postalCode}" }}") }
                            if (city?.isNotEmpty() == true || postalCode?.isNotEmpty() == true) {
                                append(",\n")
                            }
                            state?.let { append("${state},\n") }
                            country?.let { append("${country}") }
                        }
                        fullLocation.toString()
                    },
                    icons = venueItem.categories?.run {
                        var returnValue = ""
                        if (isNotEmpty()) {
                            var dao = filter {
                                it.primary == true
                                }.flatMap {
                                    listOf(
                                        IconInformation(
                                            name = it.name,
                                            prefix = it.icon?.prefix,
                                            suffix = it.icon?.suffix
                                        )
                                    )
                                }
                            returnValue = (Gson()).toJson(dao)
                        }

                        returnValue
                    }
                )
            )
        }
    }

    fun detailsResponseToDetailsEntity(response: DetailsResponse) : DetailEntity?{
        return response.response?.venue?.run {
            DetailEntity(
                venueId = id!!,
                venueName = name,
                likes = likes?.count,
                description = description,
                shortUrl = shortUrl,
                photos = response.run {
                    var dao = mutableListOf<PhotoInfo>()
                    //bestPhoto
                    bestPhoto?.apply {
                        dao.add(
                            PhotoInfo(
                                name = source?.name,
                                prefix = prefix,
                                suffix = suffix
                            )
                        )
                    }
                    //photos
                    photos?.groups?.forEach {
                        it.items?.forEach {item ->
                            dao.add(
                                PhotoInfo(
                                    name = item.source.name,
                                    prefix = item.prefix,
                                    suffix = item.suffix
                                )
                            )
                        }
                    }

                    (Gson()).toJson(dao)
                },
                ratings = rating,
                hours = defaultHours?.status,
                errorMessage = response.run {
                    "${meta?.code} : ${meta?.errorDetail}"
                }
            )
        }
    }
}