package kmm.superApp.android.ui.screens.home.widget


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kmm.superApp.domain.entity.HomeModel

@Composable
fun HomeItem(
    modifier: Modifier = Modifier,
    homeModel: HomeModel,
    onClick: (HomeModel) -> Unit
) {
    Card(
        modifier = modifier
            .height(220.dp)
            .clickable { onClick(homeModel) },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = homeModel.icon as Int),
                contentDescription = null,
                modifier = modifier
                    .padding(12.dp)
            )
            Spacer(modifier = modifier.height(4.dp))

            Text(
                text = homeModel.name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )


        }
    }

}













