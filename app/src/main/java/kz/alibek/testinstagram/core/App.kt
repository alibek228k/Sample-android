package kz.alibek.testinstagram.core

import android.app.Application
import kz.alibek.testinstagram.addpost.di.addPostModule
import kz.alibek.testinstagram.core.di.coreModule
import kz.alibek.testinstagram.home.di.homeModule
import kz.alibek.testinstagram.notification.di.notificationModule
import kz.alibek.testinstagram.profile.di.profileModule
import kz.alibek.testinstagram.search.di.searchModule
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
                    coreModule,
                    profileModule,
                    homeModule,
                    notificationModule,
                    searchModule,
                    addPostModule,
                )
            )
        }
    }
}