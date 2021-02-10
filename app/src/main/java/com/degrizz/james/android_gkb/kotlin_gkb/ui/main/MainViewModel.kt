package com.degrizz.james.android_gkb.kotlin_gkb.ui.main

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.Observer
import com.degrizz.james.android_gkb.kotlin_gkb.data.Repository
import com.degrizz.james.android_gkb.kotlin_gkb.data.model.Note
import com.degrizz.james.android_gkb.kotlin_gkb.data.model.NoteResult

class MainViewModel(val repository: Repository) :
    BaseViewModel<List<Note>?, MainViewState>() {

    private val notesObserver = object : Observer<NoteResult> {
        override fun onChanged(t: NoteResult?) {
            if (t == null) return

            when (t) {
                is NoteResult.Success<*> -> {
                    viewStateLiveData.value = MainViewState(notes = t.data as? List<Note>)
                }
                is NoteResult.Error -> {
                    viewStateLiveData.value = MainViewState(error = t.error)
                }
            }
        }
    }

    private val repositoryNotes = repository.getNotes()

    init {
        viewStateLiveData.value = MainViewState()
        repositoryNotes.observeForever(notesObserver)
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    public override fun onCleared() {
        repositoryNotes.removeObserver(notesObserver)
    }

}