package kmm.superApp.domain.repo

import kmm.superApp.data.dto.RocketLaunch

interface LaunchesRepo {

    suspend fun getAllLaunches(): List<RocketLaunch>
}