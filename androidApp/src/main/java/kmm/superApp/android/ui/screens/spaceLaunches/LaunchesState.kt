package kmm.superApp.android.ui.screens.spaceLaunches

import kmm.superApp.data.dto.RocketLaunch

data class LaunchesState (
    val isLoading: Boolean = false,
    val launches : List<RocketLaunch> = listOf(),
    val error: String = ""
)
