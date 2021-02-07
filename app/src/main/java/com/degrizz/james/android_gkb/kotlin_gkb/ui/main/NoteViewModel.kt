package com.degrizz.james.android_gkb.kotlin_gkb.ui.main

import androidx.lifecycle.Observer
import com.degrizz.james.android_gkb.kotlin_gkb.data.Repository
import com.degrizz.james.android_gkb.kotlin_gkb.data.model.Note
import com.degrizz.james.android_gkb.kotlin_gkb.data.model.NoteResult

class NoteViewModel(val repository: Repository) : BaseViewModel<NoteViewState.Data, NoteViewState>() {

    private val currentNote: Note?
        get() = viewStateLiveData.value?.data?.note

    fun saveChanges(note: Note) {
        viewStateLiveData.value = NoteViewState(NoteViewState.Data(note = note))
    }

    override fun onCleared() {
        currentNote?.let { note -> repository.saveNote(note) }
    }

    fun loadNote(noteId: String) {
        repository.getNoteById(noteId).observeForever(Observer<NoteResult> { t ->
            t?.let { noteResult ->
                viewStateLiveData.value = when(noteResult) {
                    is NoteResult.Success<*> ->
                        NoteViewState(NoteViewState.Data(note = noteResult.data as? Note))
                    is NoteResult.Error ->
                        NoteViewState(error = noteResult.error)
                }
            }
        })
    }

    fun deleteNote() {
        currentNote?.let {
            repository.deleteNote(it.id).observeForever { result ->
                result?.let { noteResult ->
                    viewStateLiveData.value = when(noteResult) {
                        is NoteResult.Success<*> ->
                            NoteViewState(NoteViewState.Data(isDeleted = true))
                        is NoteResult.Error ->
                            NoteViewState(error = noteResult.error)
                    }
                }
            }
        }
    }
}