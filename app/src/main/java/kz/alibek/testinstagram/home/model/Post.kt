package kz.alibek.testinstagram.home.model

data class Post(
    val username: String,
    val userAvatarUrl: String,
    val imageUrl: String,
    val likesCount: Int,
    val caption: String
) {
    companion object {
        val examplePost = Post(
                username = "username",
                userAvatarUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYmkp9a2rrD1Sskb9HLt5mDaTt4QaIs8CcBg&s",
                imageUrl = "https://images.pexels.com/photos/1525041/pexels-photo-1525041.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                likesCount = 100,
                caption = "Beautiful view!",
            )
    }
}
