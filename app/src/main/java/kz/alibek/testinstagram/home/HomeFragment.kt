package kz.alibek.testinstagram.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import kz.alibek.testinstagram.R
import kz.alibek.testinstagram.core.ui.BaseComposeFragment
import kz.alibek.testinstagram.home.model.Post
import kz.alibek.testinstagram.ui.theme.InstaTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseComposeFragment() {

    private val viewModel: HomeViewModel by viewModel()

    @Composable
    override fun Content() {
        InstaMainScreen()
    }

    @Composable
    private fun InstaMainScreen() {
        val posts by viewModel.post.collectAsStateWithLifecycle()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                Toolbar()
            },
        ) { paddingValues ->
            PostContent(
                modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
                posts = posts,
            )
        }
    }

    @Composable
    private fun Toolbar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.height(58.dp),
                painter = painterResource(id = R.drawable.ic_insta_logo),
                contentDescription = null,
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    modifier = Modifier.height(24.dp),
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = null,
                )
                Image(
                    modifier = Modifier.height(24.dp),
                    painter = painterResource(id = R.drawable.ic_messages),
                    contentDescription = null,
                )
            }
        }
    }

    @Composable
    private fun PostContent(
        posts: List<Post>,
        modifier: Modifier = Modifier,
    ) {

        LazyColumn(
            modifier = modifier.fillMaxSize(),
        ) {
            items(posts) { post ->

                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        AsyncImage(
                            model = post.userAvatarUrl,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(48.dp),
                            contentDescription = null,
                        )

                        Text(
                            text = post.username,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }

                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp),
                        model = post.imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = "Likes count: ${post.likesCount}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                    )

                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        text = post.caption,
                        fontSize = 12.sp,
                    )
                }
            }
        }
    }

    @Preview
    @Composable
    private fun MainScreenPreview() {
        InstaTheme {
            InstaMainScreen()
        }
    }
}