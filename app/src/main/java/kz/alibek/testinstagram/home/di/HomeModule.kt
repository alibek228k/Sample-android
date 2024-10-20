package kz.alibek.testinstagram.home.di

import kz.alibek.testinstagram.home.HomeViewModel
import kz.alibek.testinstagram.home.repository.PostRepository
import kz.alibek.testinstagram.home.repository.PostRepositoryImpl
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    viewModel {
        HomeViewModel(
            postRepository = get(),
        )
    }

    single<PostRepository> {
        PostRepositoryImpl(
            pref = get(),
            gson = get(),
        )
    }
}