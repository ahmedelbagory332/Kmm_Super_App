package kmm.superApp.android.ui.component



import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kmm.superApp.android.R

@Composable
fun CoilImage(data: String, contentDescription: String, modifier: Modifier,contentScale: ContentScale) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(data)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.placeholder),
        error = painterResource(R.drawable.placeholder),
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale,
     )
}