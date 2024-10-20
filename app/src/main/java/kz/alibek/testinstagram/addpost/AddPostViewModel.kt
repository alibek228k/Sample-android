package kz.alibek.testinstagram.addpost

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kz.alibek.testinstagram.home.model.Post
import kz.alibek.testinstagram.home.repository.PostRepository

class AddPostViewModel(
    private val postRepository: PostRepository,
): ViewModel() {

    private val _uiState = MutableStateFlow(AddPostUiState())
    val uiState: StateFlow<AddPostUiState> = _uiState.asStateFlow()

    fun dispatch(action: AddPostAction) {
        when(action) {
            is AddPostAction.OnAddPost -> addPost()
            is AddPostAction.OnCaptionValueChanged -> viewModelScope.launch {
                _uiState.emit(
                    _uiState.value.copy(
                        captionTextField = action.value,
                    )
                )
            }
            is AddPostAction.OnImageUrlValueChanged -> viewModelScope.launch {
                _uiState.emit(
                    _uiState.value.copy(
                        imageUrlTextField = action.value,
                    )
                )
            }
        }
    }

    private fun addPost() = viewModelScope.launch {
        val post = Post.examplePost.copy(
            imageUrl = _uiState.value.imageUrlTextField,
            caption = _uiState.value.captionTextField,
        )

        postRepository.addPost(post)

        _uiState.emit(
            _uiState.value.copy(
                imageUrlTextField = "",
                captionTextField = "",
            )
        )
    }

}