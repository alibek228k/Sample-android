package kz.alibek.testinstagram

import androidx.annotation.DrawableRes

sealed interface InstaData {
    data object HeaderComponent : InstaData
    data class StoriesComponent(val items: List<StoriesItem>) : InstaData
    data class PostComponent(
        @DrawableRes val avatar: Int,
        val userName: String,
        @DrawableRes val postImage: Int,
        val likesCount: Int,
        val commentsCount: Int,
        val postDescription: String,
    ) : InstaData
}

data class StoriesItem(
    @DrawableRes val icon: Int,
    val isViewed: Boolean = false,
)