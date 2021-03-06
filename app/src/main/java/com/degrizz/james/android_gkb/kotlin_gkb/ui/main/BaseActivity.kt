package com.degrizz.james.android_gkb.kotlin_gkb.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T, VS : BaseViewState<T>> : AppCompatActivity() {

    abstract val viewModel: BaseViewModel<T, VS>
    abstract val layoutRes: Int
    abstract val ui: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui.root)

        viewModel.getViewState().observe(this, object : Observer<VS> {
            override fun onChanged(t: VS?) {
                if (t == null) return
                if (t.data != null) renderData(t.data!!)
                if (t.error != null) renderError(t.error)
            }
        })
    }

    protected fun renderError(error: Throwable) {
        if (error.message != null) showError(error.message!!)
    }

    abstract fun renderData(data: T)

    protected fun showError(error: String) {
//        val snackbar = Snackbar.make(this.viewModel, error, Snackbar.LENGTH_INDEFINITE)
//        snackbar.setAction(R.string.ok_btn_title, View.OnClickListener { snackbar.dismiss() })
//        snackbar.show()
    }

}