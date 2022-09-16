package com.mikeschvedov.ifood.di

import com.mikeschvedov.ifood.data.local_data.database.RoomRepositoryIMPL
import com.mikeschvedov.ifood.data.local_data.database.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class RoomRepository

@Qualifier
annotation class RemoteRepository

@Module
@InstallIn(SingletonComponent::class)
abstract  class RepositoryModule {

    @Binds
    @Singleton
    @RoomRepository
    abstract fun bindRoomRepository(roomRepository: RoomRepositoryIMPL): Repository
}