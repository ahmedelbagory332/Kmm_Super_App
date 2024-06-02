package kmm.superApp.android.ui.screens.spaceLaunches


sealed class LaunchesIntent {
    data object GetLaunches : LaunchesIntent()
}