package com.example.codeassignment.domain.di


import com.example.codeassignment.data.repository.DataRepositoryImpl
import com.example.codeassignment.domain.repository.DataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt module that binds the repository implementation to its interface.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindDataRepository(
        impl: DataRepositoryImpl
    ): DataRepository
}
