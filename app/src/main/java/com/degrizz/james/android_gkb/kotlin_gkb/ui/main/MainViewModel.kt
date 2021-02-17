package com.degrizz.james.android_gkb.kotlin_gkb.ui.main

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.Observer
import com.degrizz.james.android_gkb.kotlin_gkb.data.Repository
import com.degrizz.james.android_gkb.kotlin_gkb.data.model.Note
import com.degrizz.james.android_gkb.kotlin_gkb.data.model.NoteResult
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel(val repository: Repository) :
    BaseViewModel<List<Note>?>() {

    private val notesChannel by lazy { runBlocking { repository.getNotes() } }

    init {
        launch {
            notesChannel.consumeEach {
                when (it) {
                    is NoteResult.Success<*> -> setData(it.data as? List<Note>)
                    is NoteResult.Error -> setError(it.error)
                }
            }
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    public override fun onCleared() {
        notesChannel.cancel()
        super.onCleared()
    }

}