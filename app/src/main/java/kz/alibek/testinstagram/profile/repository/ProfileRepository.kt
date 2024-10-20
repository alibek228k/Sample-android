package kz.alibek.testinstagram.profile.repository

import kz.alibek.testinstagram.profile.model.UserProfile

interface ProfileRepository {
    fun saveUserProfile(user: UserProfile)
    fun getUserProfile(): UserProfile
}