package com.degrizz.james.android_gkb.kotlin_gkb

import com.degrizz.james.android_gkb.kotlin_gkb.data.Repository
import com.degrizz.james.android_gkb.kotlin_gkb.data.model.FireStoreProvider
import com.degrizz.james.android_gkb.kotlin_gkb.data.model.RemoteDataProvider
import com.degrizz.james.android_gkb.kotlin_gkb.ui.main.MainViewModel
import com.degrizz.james.android_gkb.kotlin_gkb.ui.main.NoteViewModel
import com.degrizz.james.android_gkb.kotlin_gkb.ui.main.SplashViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single { FireStoreProvider(get(), get()) } bind RemoteDataProvider::class
    single { Repository(get()) }
}

val splashModule = module {
    viewModel { SplashViewModel(get()) }
}

val mainModule = module {
    viewModel { MainViewModel(get()) }
}

val noteModule = module {
    viewModel { NoteViewModel(get()) }
}