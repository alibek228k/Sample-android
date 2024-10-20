package kz.alibek.testinstagram.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kz.alibek.testinstagram.profile.model.UserProfile
import kz.alibek.testinstagram.profile.repository.ProfileRepository

class ProfileViewModel(
    private val profileRepository: ProfileRepository,
) : ViewModel() {

    private val _user = MutableStateFlow(UserProfile.defaultUser)
    val user: StateFlow<UserProfile> = _user.asStateFlow()

    init {
        getData()
    }

    private fun getData() = viewModelScope.launch {
        val userData = try {
            profileRepository.getUserProfile()
        } catch (e: NullPointerException) {
            profileRepository.saveUserProfile(UserProfile.defaultUser)
            UserProfile.defaultUser
        }
        _user.emit(userData)
    }
}