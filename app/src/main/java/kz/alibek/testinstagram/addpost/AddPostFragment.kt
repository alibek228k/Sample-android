package kz.alibek.testinstagram.addpost

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kz.alibek.testinstagram.core.ui.BaseComposeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddPostFragment: BaseComposeFragment() {

    private val viewModel: AddPostViewModel by viewModel()

    @Composable
    override fun Content() {
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        AddPostScreen(
            uiState = uiState,
            onAction = viewModel::dispatch
        )
    }
}