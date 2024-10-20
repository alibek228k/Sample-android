package kz.alibek.testinstagram.addpost

sealed interface AddPostAction {
    data object OnAddPost : AddPostAction
    data class OnCaptionValueChanged(val value: String): AddPostAction
    data class OnImageUrlValueChanged(val value: String): AddPostAction
}