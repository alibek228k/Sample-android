package kz.alibek.testinstagram.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import kz.alibek.testinstagram.notification.model.Notification

@Composable
fun NotificationScreen(
    notifications: List<Notification>,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Notifications",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding())
                .padding(horizontal = 16.dp),
        ) {
            items(notifications) { notification ->
                when (notification) {
                    is Notification.MightKnow -> MightKnowContent(notification)
                    is Notification.Like -> LikeContent(notification)
                    is Notification.Comment -> CommentContent(notification)
                }
            }
        }
    }
}

@Composable
private fun MightKnowContent(notification: Notification.MightKnow) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .size(48.dp),
            painter = rememberAsyncImagePainter(model = notification.profileImageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Text(
            text = "${notification.username}, who might know, is on Instagram",
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
private fun LikeContent(notification: Notification.Like) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .size(48.dp),
            painter = rememberAsyncImagePainter(model = notification.profileImageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Text(
            text = "${notification.username}, liked your post",
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
private fun CommentContent(notification: Notification.Comment) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .size(48.dp),
            painter = rememberAsyncImagePainter(model = notification.profileImageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Text(
            text = "${notification.username}, commented your post",
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}