package kz.alibek.testinstagram.profile.model

import kz.alibek.testinstagram.home.model.Post

data class UserProfile(
    val userAvatarUrl: String,
    val username: String,
    val postsCount: String,
    val followersCount: String,
    val followingCount: String,
    val userProfileDescription: String,
    val posts: List<Post>
) {
    companion object {
        val defaultUser = UserProfile(
            userAvatarUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYmkp9a2rrD1Sskb9HLt5mDaTt4QaIs8CcBg&s",
            username = "username",
            postsCount = "0",
            followersCount = "0",
            followingCount = "0",
            userProfileDescription = "Some description",
            posts = emptyList(),
        )
    }
}
