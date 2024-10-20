package kz.alibek.testinstagram.core.di

import android.content.Context
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val SHARED_PREFERENCES_SOURCE = "SHARED_PREFERENCES_SOURCE"

val coreModule = module { 
    single {
        Gson()
    }

    single {
        androidContext().getSharedPreferences(
            SHARED_PREFERENCES_SOURCE,
            Context.MODE_PRIVATE,
        )
    }
}