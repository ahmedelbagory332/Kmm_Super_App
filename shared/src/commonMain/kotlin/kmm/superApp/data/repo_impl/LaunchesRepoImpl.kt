package kmm.superApp.data.repo_impl

import kmm.superApp.data.network.AppApi
import kmm.superApp.data.dto.RocketLaunch
import kmm.superApp.domain.repo.LaunchesRepo

class LaunchesRepoImpl(private val api: AppApi) : LaunchesRepo {

    override suspend fun getAllLaunches(): List<RocketLaunch> {
        return api.getAllLaunches()

    }
}