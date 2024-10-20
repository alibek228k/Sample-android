package kz.alibek.testinstagram.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import kz.alibek.testinstagram.R
import kz.alibek.testinstagram.profile.model.UserProfile

@Composable
fun ProfileScreen(
    user: UserProfile,
//    onAction: (ProfileAction) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp,
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = user.username,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_threads),
                    contentDescription = null,
                )

                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_add_box),
                    contentDescription = null,
                    tint = Color.Black,
                )

                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = rememberVectorPainter(image = Icons.Default.Menu),
                    contentDescription = null,
                    tint = Color.Black,
                )
            }
        }
    ) { paddingValues ->
        ProfileScreenContent(
            modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
            user = user,
        )
    }
}

@Composable
private fun ProfileScreenContent(
    user: UserProfile,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(54.dp),
                    painter = rememberAsyncImagePainter(model = user.userAvatarUrl),
                    contentDescription = null,
                )

                Text(
                    text = user.username,
                    fontSize = 14.sp,
                )
            }

            Spacer(modifier = Modifier.width(62.dp))

            Box(
                modifier = Modifier.weight(1f),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = user.postsCount,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                    )
                    Text(
                        text = "posts",
                        fontSize = 14.sp,
                    )
                }
            }

            Box(
                modifier = Modifier.weight(1f),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = user.followersCount,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                    )
                    Text(
                        text = "follower",
                        fontSize = 14.sp,
                    )
                }
            }

            Box(
                modifier = Modifier.weight(1f),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = user.followingCount,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                    )
                    Text(
                        text = "following",
                        fontSize = 14.sp,
                    )
                }
            }
        }

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = user.userProfileDescription,
            fontSize = 14.sp,
        )

        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
           Box(
               modifier = Modifier
                   .weight(1f)
                   .clip(RoundedCornerShape(8.dp))
                   .background(Color.Black.copy(alpha = 0.2f)),
               contentAlignment = Alignment.Center,
           ) {
               Text(text = "Edit profile")
           }
            
           Box(
               modifier = Modifier
                   .weight(1f)
                   .clip(RoundedCornerShape(8.dp))
                   .background(Color.Black.copy(alpha = 0.2f)),
               contentAlignment = Alignment.Center,
           ) {
               Text(text = "Share profile")
           }
            
           Box(
               modifier = Modifier
                   .clip(RoundedCornerShape(8.dp))
                   .background(Color.Black.copy(alpha = 0.2f)),
               contentAlignment = Alignment.Center,
           ) {
               Icon(
                   modifier = Modifier.size(24.dp),
                   painter = rememberVectorPainter(image = Icons.Outlined.Person),
                   contentDescription = null,
                   tint = Color.Black,
               )
           }
        }

        Spacer(modifier = Modifier.height(20.dp))


        LazyVerticalGrid(
            modifier = modifier.fillMaxSize(),
            columns = GridCells.Fixed(3),
        ) {
           items(user.posts) { post ->
               Image(
                   modifier = Modifier.size(128.dp),
                   painter = rememberAsyncImagePainter(model = post.imageUrl),
                   contentScale = ContentScale.Crop,
                   contentDescription = null,
               )
           }
        }
    }
}

@Composable
@Preview
private fun ProfileScreenPreview() {
    ProfileScreen(UserProfile.defaultUser)
}