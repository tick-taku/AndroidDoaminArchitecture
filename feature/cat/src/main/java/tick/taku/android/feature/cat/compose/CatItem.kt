package tick.taku.android.feature.cat.compose

import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import tick.taku.android.core.entity.Cat

@Composable
fun CatItem(
    cat: Cat,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).apply { data(cat.url.url) }.build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}