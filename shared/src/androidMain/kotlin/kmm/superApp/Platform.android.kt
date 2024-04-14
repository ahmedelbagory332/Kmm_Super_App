package kmm.superApp


import app.cache.AppDatabase
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import io.ktor.client.engine.android.Android
import kmm.superApp.data.cache.DatabaseWrapper
import kmm.superApp.data.repo_impl.HomeRepoImpl
import kmm.superApp.domain.repo.HomeRepo
import org.koin.dsl.module


actual fun platformModule() = module {
    single {
        val driver = AndroidSqliteDriver(
            AppDatabase.Schema,
            get(),
            "space.db"
        )
        DatabaseWrapper(AppDatabase(driver))
    }
    single { Android.create() }
    single<HomeRepo> { HomeRepoImpl() }
}