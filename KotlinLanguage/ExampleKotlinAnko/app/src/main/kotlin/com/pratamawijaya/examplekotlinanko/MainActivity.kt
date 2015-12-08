package com.pratamawijaya.examplekotlinanko

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.button
import org.jetbrains.anko.editText
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        linearLayout {
            val editName = editText {
                button("jogja") {
                    onClick { "Papoy" }
                }
            }
        }

    }
}
