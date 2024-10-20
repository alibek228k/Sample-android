package kz.alibek.testinstagram.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kz.alibek.testinstagram.home.model.Post
import kz.alibek.testinstagram.home.repository.PostRepository

class HomeViewModel(
    private val postRepository: PostRepository,
) : ViewModel() {

    private val _posts: MutableStateFlow<List<Post>> = MutableStateFlow(emptyList())
    val post: StateFlow<List<Post>> = _posts.asStateFlow()

    init {
        getData()
    }

    private fun getData() = viewModelScope.launch {
        val posts = try {
            postRepository.getPosts()
        } catch (e: NullPointerException) {
            postRepository.savePosts(listOf(Post.examplePost, Post.examplePost))
            listOf(Post.examplePost, Post.examplePost)
        }
        _posts.emit(posts)
    }
}