package a.room.with.a.view.api

import a.room.with.a.view.common.RequestConstants
import okhttp3.Interceptor
import okhttp3.Response

class QueryParamInterceptors: Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url.newBuilder()
            .addQueryParameter("client_id", RequestConstants.clientId)
            .addQueryParameter("client_secret", RequestConstants.clientSecret)
            .addQueryParameter("v", RequestConstants.v())
            .build()
        val request = chain.request().newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }
}