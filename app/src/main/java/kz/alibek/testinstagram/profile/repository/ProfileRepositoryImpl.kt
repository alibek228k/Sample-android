package kz.alibek.testinstagram.profile.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import kz.alibek.testinstagram.home.repository.PostRepository
import kz.alibek.testinstagram.profile.model.UserProfile

private const val USER_KEY = "USER_KEY"

class ProfileRepositoryImpl(
    private val pref: SharedPreferences,
    private val gson: Gson,
    private val postRepository: PostRepository,
) : ProfileRepository {

    override fun saveUserProfile(user: UserProfile) {
        pref.edit {
            putString(USER_KEY, gson.toJson(user))
        }
    }

    override fun getUserProfile(): UserProfile {
        return gson.fromJson(pref.getString(USER_KEY, ""), UserProfile::class.java).copy(
            posts = postRepository.getPosts()
        )
    }
}