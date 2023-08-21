package tick.taku.android.feature.cat.state

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import tick.taku.android.feature.cat.viewmodel.CatsViewModel

interface CatsScreenState {

    val uiState: CatsViewModel.UiState
        @Composable get

    val scaffoldState: ScaffoldState

    fun onBackPressed()
    fun onRefresh()
}