package kz.alibek.testinstagram.search

sealed interface SearchAction {
    data class OnSearchTextChanged(val text: String): SearchAction
}