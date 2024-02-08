package com.example.dualinjectproblem

import android.content.Context
import androidx.startup.Initializer
import com.example.dualinjectproblem.di.SingleInstanceClass
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.EarlyEntryPoint
import dagger.hilt.android.EarlyEntryPoints
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@EntryPoint
@InstallIn(SingletonComponent::class)
interface InitializerEntryPoint {

    fun inject(workManagerInitializer: WorkManagerInitializer)

    companion object {
        fun resolve(context: Context): InitializerEntryPoint {
            val appContext = context.applicationContext
            return EntryPointAccessors.fromApplication(appContext, InitializerEntryPoint::class.java)
        }
    }
}

class WorkManagerInitializer : Initializer<Unit> {
    @Inject
    lateinit var singleInstanceClass: SingleInstanceClass

    override fun create(context: Context) {
        InitializerEntryPoint.resolve(context).inject(this)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        // No dependencies on other libraries.
        return emptyList()
    }
}
