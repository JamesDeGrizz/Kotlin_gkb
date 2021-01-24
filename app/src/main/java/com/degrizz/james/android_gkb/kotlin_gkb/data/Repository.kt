package com.degrizz.james.android_gkb.kotlin_gkb.data

import com.degrizz.james.android_gkb.kotlin_gkb.data.model.Note

object Repository {
    private val notes: List<Note> = listOf(
        /*
        * Note(Resources.getSystem().getString(R.string.noteTitle),
            Resources.getSystem().getString(R.string.noteContent),
            0xfff06292.toInt())
            falls with java.lang.ExceptionInInitializerError
            ......
            Caused by: android.content.res.Resources$NotFoundException: String resource ID #0x7f0e0050
            idk why
        * */
        Note("Моя первая заметка",
            "Kotlin очень краткий, но при этом выразительный язык",
            0xfff06292.toInt()),
        Note("Моя первая заметка",
            "Kotlin очень краткий, но при этом выразительный язык",
            0xff9575cd.toInt()),
        Note("Моя первая заметка",
            "Kotlin очень краткий, но при этом выразительный язык",
            0xff64b5f6.toInt()),
        Note("Моя первая заметка",
            "Kotlin очень краткий, но при этом выразительный язык",
            0xff4db6ac.toInt()),
        Note("Моя первая заметка",
            "Kotlin очень краткий, но при этом выразительный язык",
            0xffb2ff59.toInt()),
        Note("Моя первая заметка",
            "Kotlin очень краткий, но при этом выразительный язык",
            0xffffeb3b.toInt()),
        Note("Моя первая заметка",
            "Kotlin очень краткий, но при этом выразительный язык",
            0xffff6e40.toInt())
    )
}