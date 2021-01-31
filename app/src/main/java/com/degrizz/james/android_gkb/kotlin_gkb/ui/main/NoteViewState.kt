package com.degrizz.james.android_gkb.kotlin_gkb.ui.main

import com.degrizz.james.android_gkb.kotlin_gkb.data.model.Note

class NoteViewState(val note: Note? = null, error: Throwable? = null) :
    BaseViewState<Note?>(note, error)