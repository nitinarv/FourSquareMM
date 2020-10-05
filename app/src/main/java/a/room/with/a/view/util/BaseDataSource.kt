package a.room.with.a.view.util

import retrofit2.Response


abstract class BaseDataSource {

    protected suspend fun <T, R> getResultWithCast(call: suspend () -> Response<T>,
                                                   transformer: (T) -> R
    ): Resource<R> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.success(transformer(body))
            }
            return error(message = "${response.code()} ${response.message()} ${response.errorBody()?.string()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String, data: T? = null): Resource<T> {
        return Resource.error(message = "Network call has failed for a following reason: $message", data = data)
    }
}