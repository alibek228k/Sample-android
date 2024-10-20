package kz.alibek.testinstagram.addpost.di

import kz.alibek.testinstagram.addpost.AddPostViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val addPostModule = module {

    viewModel {
        AddPostViewModel(
            postRepository = get(),
        )
    }
}