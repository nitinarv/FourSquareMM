package a.room.with.a.view.di

import a.room.with.a.view.api.FourSquareService
import a.room.with.a.view.api.QueryParamInterceptors
import android.content.Context
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, httpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.foursquare.com/v2/venues/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        //Logger
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val queryParamInterceptor = QueryParamInterceptors()

        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(loggingInterceptor)
        okHttpClientBuilder.addInterceptor(queryParamInterceptor)

        return okHttpClientBuilder.build()

    }

    @Singleton
    @Provides
    fun provideFourSquareService(retrofit: Retrofit): FourSquareService = retrofit.create(
        FourSquareService::class.java)

    @Provides
    fun provideImagPipelineConfig(@ApplicationContext appContext: Context, okHttpClient: OkHttpClient): ImagePipelineConfig {
        return OkHttpImagePipelineConfigFactory
            .newBuilder(appContext, okHttpClient)
            .build()
    }
}

