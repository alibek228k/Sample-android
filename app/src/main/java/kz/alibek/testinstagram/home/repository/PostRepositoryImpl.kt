package kz.alibek.testinstagram.home.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kz.alibek.testinstagram.home.model.Post

private const val POSTS_KEY = "POSTS_KEY"

class PostRepositoryImpl(
    private val pref: SharedPreferences,
    private val gson: Gson,
) : PostRepository {

    override fun savePosts(posts: List<Post>) {
        val postsJsonString = gson.toJson(
            Posts(posts)
        )
        pref.edit {
            putString(POSTS_KEY, postsJsonString)
        }
    }

    override fun getPosts(): List<Post> {
        val postsJsonString = pref.getString(POSTS_KEY, "")
        return gson.fromJson(postsJsonString, Posts::class.java).posts
    }

    override fun addPost(post: Post) {
        val postsList = getPosts()
        savePosts(postsList + post)
    }
}

data class Posts(
    val posts: List<Post>
)