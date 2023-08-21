package tick.taku.android.feature.cat.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tick.taku.android.core.entity.Cat

@Composable
fun CatImages(
    cats: List<Cat>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp),
        modifier = modifier
    ) {
        items(cats) {
            CatItem(
                cat = it,
                modifier = Modifier.padding(4.dp).aspectRatio(0.8f)
            )
        }
    }
}