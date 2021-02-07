package com.degrizz.james.android_gkb.kotlin_gkb.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.degrizz.james.android_gkb.kotlin_gkb.R
import com.degrizz.james.android_gkb.kotlin_gkb.data.model.Note
import com.degrizz.james.android_gkb.kotlin_gkb.databinding.ActivityMainBinding
import com.firebase.ui.auth.AuthUI
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<List<Note>?, MainViewState>(), LogoutDialog.LogoutListener {
    override val viewModel: MainViewModel by viewModel()
    override val ui: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override val layoutRes: Int = R.layout.activity_main
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui.root)
        setSupportActionBar(ui.toolbar)

        adapter = MainAdapter( object : OnItemClickListener {
            override fun onItemClick(note: Note) {
                openNoteScreen(note)
            }
        })
        ui.mainRecycler.adapter = adapter

        ui.fab.setOnClickListener( { openNoteScreen(null) })
    }

    override fun renderData(data: List<Note>?) {
        if (data == null) return
        adapter.notes = data
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean =
        MenuInflater(this).inflate(R.menu.menu_main, menu).let { true }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when(item.itemId) {
            R.id.logout -> showLogoutDialog().let { true }
            else -> false
        }

    private fun showLogoutDialog() {
        supportFragmentManager.findFragmentByTag(LogoutDialog.TAG) ?:
        LogoutDialog.createInstance().show(supportFragmentManager, LogoutDialog.TAG)
    }

    private fun openNoteScreen(note: Note?) {
        val intent = NoteActivity.getStartIntent(this, note?.id)
        startActivity(intent)
    }

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onLogout() {
        AuthUI.getInstance()
            .signOut(this)
            .addOnCompleteListener {
                startActivity(Intent(this, SplashActivity::class.java))
                finish()

            }
    }
}