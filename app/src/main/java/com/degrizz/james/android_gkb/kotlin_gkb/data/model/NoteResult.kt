package com.degrizz.james.android_gkb.kotlin_gkb.data.model

sealed class NoteResult {

    data class Success<out T>(val data: T) : NoteResult()

    data class Error(val error: Throwable) : NoteResult()
}