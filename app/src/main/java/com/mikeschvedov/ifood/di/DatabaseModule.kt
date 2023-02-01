package com.mikeschvedov.ifood.di

import android.content.Context
import androidx.room.Room
import com.mikeschvedov.ifood.data.local_data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val DBName = "FoodDB"

    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        Room.databaseBuilder(appContext, AppDatabase::class.java, DBName)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideFoodDao(appDB: AppDatabase) =
        appDB.foodEntryDao()
}