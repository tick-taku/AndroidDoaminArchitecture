package tick.taku.android.feature.cat.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tick.taku.android.feature.cat.state.CatsScreenState
import tick.taku.android.feature.cat.state.rememberCatsScreenState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CatsScreen(state: CatsScreenState = rememberCatsScreenState()) {
    val uiState = state.uiState

    Scaffold(
        scaffoldState = state.scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("Cats") },
                navigationIcon = {
                    IconButton(onClick = { state.onBackPressed() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back Arrow")
                    }
                },
                actions = {
                    IconButton(onClick = { state.onRefresh() }) {
                        Icon(Icons.Filled.Refresh, contentDescription = "Refresh")
                    }
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) {
        CatImages(
            cats = uiState.cats,
            modifier = Modifier
        )
    }
}