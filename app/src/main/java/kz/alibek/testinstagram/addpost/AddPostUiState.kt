package kz.alibek.testinstagram.addpost

import androidx.compose.runtime.Immutable

@Immutable
data class AddPostUiState(
    val imageUrlTextField: String = "",
    val captionTextField: String = "",
)