package kmm.superApp.android.ui.screens.spaceLaunches.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kmm.superApp.data.dto.RocketLaunch

@Composable
fun RocketLaunchRow(rocketLaunch: RocketLaunch) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text("Launch name: ${rocketLaunch.missionName}", fontWeight = FontWeight.Bold)
        Text(launchText(rocketLaunch), color = launchColor(rocketLaunch))
        Text("Launch year: ${rocketLaunch.launchYear}")
        Text("Launch details: ${rocketLaunch.details ?: ""}")
    }
}

@Composable
private fun launchText(rocketLaunch: RocketLaunch): String {
    return if (rocketLaunch.launchSuccess != null) {
        if (rocketLaunch.launchSuccess!!) "Successful" else "Unsuccessful"
    } else {
        "No data"
    }
}

@Composable
private fun launchColor(rocketLaunch: RocketLaunch): Color {
    return if (rocketLaunch.launchSuccess != null) {
        if (rocketLaunch.launchSuccess!!) Color.Green else Color.Red
    } else {
        Color.Gray
    }
}
