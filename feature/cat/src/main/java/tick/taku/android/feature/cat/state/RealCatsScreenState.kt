package tick.taku.android.feature.cat.state

import android.app.Activity
import android.content.Context
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import tick.taku.android.feature.cat.viewmodel.CatsViewModel

class RealCatsScreenState(
    override val scaffoldState: ScaffoldState,
    private val viewModel: CatsViewModel,
    private val context: Context,
    coroutineScope: CoroutineScope,
    lifecycle: Lifecycle
): CatsScreenState {

    override val uiState: CatsViewModel.UiState
        @Composable get() = viewModel.uiState.collectAsState().value

    init {
        viewModel.uiEvent.collectOnLifecycle(coroutineScope, lifecycle) {
            when (it) {
                is CatsViewModel.UiEvent.Error -> {
                    scaffoldState.snackbarHostState.showSnackbar(it.e.message.orEmpty())
                }
            }
        }
    }

    override fun onBackPressed() {
        (context as Activity).finish()
    }

    override fun onRefresh() {
        viewModel.fetchCats()
    }
}

inline fun <T> Flow<T>.collectOnLifecycle(
    coroutineScope: CoroutineScope,
    lifecycle: Lifecycle,
    observationState: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline action: suspend (value: T) -> Unit
) {
    coroutineScope.launch {
        lifecycle.repeatOnLifecycle(observationState) {
            collect {
                action(it)
            }
        }
    }
}

@Composable
fun rememberCatsScreenState(
    viewModel: CatsViewModel = hiltViewModel(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    context: Context = LocalContext.current,
    lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle
): CatsScreenState = remember {
    RealCatsScreenState(scaffoldState, viewModel, context, coroutineScope, lifecycle)
}