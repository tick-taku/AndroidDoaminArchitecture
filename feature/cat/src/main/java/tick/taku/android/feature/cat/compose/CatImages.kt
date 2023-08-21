package tick.taku.android.feature.cat.compose

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tick.taku.android.core.entity.Cat

@Composable
fun CatImages(
    cats: List<Cat>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = modifier) {
        items(cats) {
            CatItem(cat = it)
        }
    }
}