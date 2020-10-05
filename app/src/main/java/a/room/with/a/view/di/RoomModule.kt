package a.room.with.a.view.di


import a.room.with.a.view.room.AppDatabase
import a.room.with.a.view.room.dao.DetailDao
import a.room.with.a.view.room.dao.SearchDao
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "foursquare.db"
        ).build()
    }

    @Provides
    fun provideDetailDao(database: AppDatabase): DetailDao {
        return database.detailDao()
    }


    @Provides
    fun provideSearchDao(database: AppDatabase): SearchDao {
        return database.searchDao()
    }
}

