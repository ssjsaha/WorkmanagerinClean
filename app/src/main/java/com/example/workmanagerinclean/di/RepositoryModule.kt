package com.example.workmanagerinclean.di

import com.example.workmanagerinclean.data.remote.repository.PostRepoImpl
import com.example.workmanagerinclean.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPostRepo(postRepoImpl: PostRepoImpl): PostRepository
}
