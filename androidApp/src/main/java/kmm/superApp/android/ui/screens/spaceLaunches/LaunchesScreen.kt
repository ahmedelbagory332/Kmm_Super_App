package kmm.superApp.android.ui.screens.spaceLaunches

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kmm.superApp.android.ui.component.ErrorHolder
import kmm.superApp.android.ui.component.LoadingIndicator
import kmm.superApp.android.ui.component.TopBar
import kmm.superApp.android.ui.screens.spaceLaunches.widget.RocketLaunchRow
import org.koin.androidx.compose.koinViewModel


@Composable
fun LaunchesScreen(
    mainNavController: NavHostController,
    viewModel: LaunchesViewModel = koinViewModel(),
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = colorScheme.primary)

    val state = viewModel.launches.value

    if (state.isLoading) {

        LoadingIndicator()

    } else if (state.error.isNotEmpty()) {

        ErrorHolder(text = state.error)

    } else {


        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopBar(title = "Launches Screen", menu = {})
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                items(items = state.launches) { launch ->
                    RocketLaunchRow(rocketLaunch = launch)
                }
            }
        }


    }

}