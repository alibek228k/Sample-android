package kz.alibek.testinstagram.home.repository

import kz.alibek.testinstagram.home.model.Post

interface PostRepository {
    fun savePosts(posts: List<Post>)
    fun getPosts(): List<Post>
    fun addPost(post: Post)
}