package kmm.superApp.android

import android.app.Application
import kmm.superApp.android.di.appModule
import kmm.superApp.di.commonModule
import kmm.superApp.platformModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Application : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(commonModule(), appModule, platformModule())
        }

    }
}