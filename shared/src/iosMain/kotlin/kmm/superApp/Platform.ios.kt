package kmm.superApp

import app.cache.AppDatabase
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import io.ktor.client.engine.darwin.Darwin
import kmm.superApp.data.cache.DatabaseWrapper
import kmm.superApp.data.repo_impl.HomeRepoImpl
import kmm.superApp.domain.repo.HomeRepo
import org.koin.dsl.module



actual fun platformModule() = module {
    single {
        val driver = NativeSqliteDriver(AppDatabase.Schema, "space.db")
        DatabaseWrapper(AppDatabase(driver))

    }
    single { Darwin.create() }
    single<HomeRepo> { HomeRepoImpl() }


}