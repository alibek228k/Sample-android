package kz.alibek.testinstagram.profile.di

import kz.alibek.testinstagram.profile.ProfileViewModel
import kz.alibek.testinstagram.profile.repository.ProfileRepository
import kz.alibek.testinstagram.profile.repository.ProfileRepositoryImpl
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val profileModule = module {

    factory<ProfileRepository> {
        ProfileRepositoryImpl(
            pref = get(),
            gson = get(),
            postRepository = get(),
        )
    }

    viewModel {
        ProfileViewModel(
            profileRepository = get(),
        )
    }
}