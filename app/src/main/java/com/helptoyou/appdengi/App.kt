package com.helptoyou.appdengi

import android.app.Application
import com.helptoyou.di.apiModule
import com.helptoyou.di.navigationModule
import com.helptoyou.di.repositoriesModule
import com.helptoyou.di.useCasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    apiModule,
                    repositoriesModule,
                    useCasesModule,
                    navigationModule
                )
            )
        }
    }
}