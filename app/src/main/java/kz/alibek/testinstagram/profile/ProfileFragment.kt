package kz.alibek.testinstagram.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kz.alibek.testinstagram.core.ui.BaseComposeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseComposeFragment() {

    private val viewModel: ProfileViewModel by viewModel()

    @Composable
    override fun Content() {
        val user by viewModel.user.collectAsStateWithLifecycle()

        ProfileScreen(user = user)
    }
}