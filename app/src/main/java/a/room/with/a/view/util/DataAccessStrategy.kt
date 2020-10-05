package a.room.with.a.view.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun <T> performGetOperation(
    networkCall: suspend () -> Resource<T?>,
    databaseQuery: suspend () -> T?,
    databaseSave: suspend (T) -> Unit,
    inMemoryGet: () -> T?,
    inMemorySave: suspend (T) -> Unit,
    isNotEmpty: (T?) -> Boolean,
    emit: (Resource<T>) -> Unit
) {
    CoroutineScope(Dispatchers.IO).launch {
        emit(Resource.loading())

        val inMemoryData = inMemoryGet.invoke()
        if (isNotEmpty(inMemoryData)) {
            inMemoryData?.let { emit(Resource.success(it)) }
        } else {
            var databaseData: T? = null
            try {
                databaseData = databaseQuery.invoke()
            } catch (e: Exception) {
                databaseData = null
            } finally {
                if (isNotEmpty(databaseData)) {
                    databaseData?.let {
                        emit(Resource.success(it))
                        inMemorySave(it)
                    }
                } else {
                    val responseData = networkCall.invoke()
                    if (responseData.status == Resource.Status.SUCCESS) {
                        responseData.data?.let {
                            if (isNotEmpty(it)) {
                                databaseSave.invoke(it)
                                inMemorySave.invoke(it)
                            } else {
                                emit(Resource.empty(it))
                            }
                        }
                    }
                    emit(responseData as Resource<T>)
                }
            }
        }
    }
}