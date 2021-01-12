package com.degrizz.james.android_gkb.kotlin_gkb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_click_me)
                .setOnClickListener {
                    var btn = (it as Button)
                    btn.text = if (btn.text == "clicked!") "click me" else "clicked!"
                }
    }
}