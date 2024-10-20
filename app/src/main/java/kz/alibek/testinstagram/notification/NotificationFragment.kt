package kz.alibek.testinstagram.notification

import androidx.compose.runtime.Composable
import kz.alibek.testinstagram.core.ui.BaseComposeFragment
import kz.alibek.testinstagram.notification.model.Notification

class NotificationFragment : BaseComposeFragment() {

    @Composable
    override fun Content() {
        NotificationScreen(
            notifications = Notification.exampleList
        )
    }
}