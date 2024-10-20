package kz.alibek.testinstagram.search

import kz.alibek.testinstagram.home.model.Post

data class SearchUiState(
    val searchText: String = "",
    val searchResult: List<Post> = emptyList()
)