package com.example.dualinjectproblem.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Singleton

class SingleInstanceClass {
    init {
        val currentCount = counter.getAndIncrement()
        if (currentCount > 0) {
            throw IllegalStateException("SingleInstanceClass should only be created once")
        }
    }

    fun getGreeting() = "SingleInstanceClass"

    companion object {
        var counter: AtomicInteger = AtomicInteger(0)
    }
}

@Module
@InstallIn(SingletonComponent::class)
class SingleInstanceModule {
    @Provides
    @Singleton
    fun provideSingleInstanceClass(): SingleInstanceClass =
        SingleInstanceClass()
}