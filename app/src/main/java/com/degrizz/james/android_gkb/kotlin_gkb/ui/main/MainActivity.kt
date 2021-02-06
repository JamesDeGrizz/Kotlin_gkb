package com.degrizz.james.android_gkb.kotlin_gkb.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.degrizz.james.android_gkb.kotlin_gkb.R
import com.degrizz.james.android_gkb.kotlin_gkb.data.model.Note
import com.degrizz.james.android_gkb.kotlin_gkb.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<List<Note>?, MainViewState>() {
    override val viewModel: MainViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    override val layoutRes: Int = R.layout.activity_main
    private lateinit var adapter: MainAdapter
    override val ui: ActivityMainBinding
            by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui.root)
        setSupportActionBar(toolbar)

        adapter = MainAdapter( object : OnItemClickListener {
            override fun onItemClick(note: Note) {
                openNoteScreen(note)
            }
        })
        mainRecycler.adapter = adapter

        fab.setOnClickListener( { openNoteScreen(null) })
    }

    override fun renderData(data: List<Note>?) {
        if (data == null) return
        adapter.notes = data
    }

    private fun openNoteScreen(note: Note?) {
        val intent = NoteActivity.getStartIntent(this, note?.id)
        startActivity(intent)
    }

}