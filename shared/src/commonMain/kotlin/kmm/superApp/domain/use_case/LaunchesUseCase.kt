package kmm.superApp.domain.use_case

import data.cache.LocalDatabase
import kmm.superApp.data.dto.RocketLaunch
import kmm.superApp.domain.repo.LaunchesRepo
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LaunchesUseCase : KoinComponent {

    private val launchesRepo: LaunchesRepo by inject()
    private val localDatabase: LocalDatabase by inject()

    suspend operator fun invoke(): List<RocketLaunch> {
        try {
            val allRemoteLaunches = launchesRepo.getAllLaunches()
            localDatabase.clearDatabase()
            localDatabase.createLaunches(allRemoteLaunches)
            return localDatabase.getAllLaunches()

        } catch (e: Exception) {
            val localLaunches = localDatabase.getAllLaunches()
            if (localLaunches.isNotEmpty()) {
                return localLaunches
            }
            return listOf()
        }

    }

}