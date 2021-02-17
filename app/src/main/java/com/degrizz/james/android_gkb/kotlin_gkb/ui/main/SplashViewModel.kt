package com.degrizz.james.android_gkb.kotlin_gkb.ui.main

import com.degrizz.james.android_gkb.kotlin_gkb.data.Repository
import com.degrizz.james.android_gkb.kotlin_gkb.data.model.NoAuthException
import kotlinx.coroutines.launch

class SplashViewModel(private val repository: Repository): BaseViewModel<Boolean>() {

    fun requestUser() {
        launch {
            repository.getCurrentUser()?.let {
                setData(true)
            } ?: setError(NoAuthException())
        }
    }
}