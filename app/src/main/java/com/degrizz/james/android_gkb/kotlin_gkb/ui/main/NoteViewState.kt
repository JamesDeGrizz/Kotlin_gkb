package com.degrizz.james.android_gkb.kotlin_gkb.ui.main

import com.degrizz.james.android_gkb.kotlin_gkb.data.model.Note

class NoteViewState(data: Data = Data(), error: Throwable? = null) :
    BaseViewState<NoteViewState.Data>(data, error) {

    data class Data(val isDeleted: Boolean = false, val note: Note? = null)
}

