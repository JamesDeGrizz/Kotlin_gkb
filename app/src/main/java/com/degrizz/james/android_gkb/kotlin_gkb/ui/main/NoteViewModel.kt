package com.degrizz.james.android_gkb.kotlin_gkb.ui.main

import androidx.lifecycle.Observer
import com.degrizz.james.android_gkb.kotlin_gkb.data.Repository
import com.degrizz.james.android_gkb.kotlin_gkb.data.model.Note
import com.degrizz.james.android_gkb.kotlin_gkb.data.model.NoteResult
import kotlinx.coroutines.launch

class NoteViewModel(val repository: Repository) : BaseViewModel<NoteViewState.Data>() {

    private val currentNote: Note?
        get() = getViewState().poll()?.note

    fun saveChanges(note: Note) {
        setData(NoteViewState.Data(note = note))
    }

    fun loadNote(noteId: String) {
        launch {
            try {
                setData(NoteViewState.Data(note = repository.getNoteById(noteId)))
            }
            catch (e: Throwable) {
                setError(e)
            }
        }
    }

    fun deleteNote() {
        launch {
            try {
                currentNote?.let {
                    repository.deleteNote(noteId = it.id)
                }
                setData(NoteViewState.Data(isDeleted = true))
            }
            catch (e: Throwable) {
                setError(e)
            }
        }
    }

    override fun onCleared() {
        launch {
            currentNote?.let { note -> repository.saveNote(note) }
            super.onCleared()
        }
    }
}