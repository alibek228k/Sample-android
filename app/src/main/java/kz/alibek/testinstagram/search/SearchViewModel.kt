package kz.alibek.testinstagram.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kz.alibek.testinstagram.home.repository.PostRepository

class SearchViewModel(
    private val postRepository: PostRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    fun dispatch(action: SearchAction) {
        when (action) {
            is SearchAction.OnSearchTextChanged -> searchTextChanged(action.text)
        }
    }

    private fun searchTextChanged(text: String) = viewModelScope.launch(Dispatchers.Default) {
        val posts = postRepository.getPosts()
        val filteredPosts = posts.filter { it.caption.lowercase().contains(text) }

        _uiState.emit(_uiState.value.copy(
            searchText = text,
            searchResult = filteredPosts,
        ))
    }
}