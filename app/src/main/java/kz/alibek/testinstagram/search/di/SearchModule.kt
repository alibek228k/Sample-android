package kz.alibek.testinstagram.search.di

import kz.alibek.testinstagram.search.SearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val searchModule = module {
    viewModel {
        SearchViewModel(
            postRepository = get(),
        )
    }
}