package kz.alibek.testinstagram.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kz.alibek.testinstagram.core.ui.BaseComposeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseComposeFragment() {

    private val viewModel: SearchViewModel by viewModel()

    @Composable
    override fun Content() {
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        SearchScreen(
            onAction = viewModel::dispatch,
            uiState = uiState,
        )
    }
}