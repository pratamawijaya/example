package com.pratamawijaya.basickotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.pratamawijaya.basickotlin.R
import com.pratamawijaya.basickotlin.model.Person
import kotlinx.android.synthetic.activity_main.message

class MainActivity : AppCompatActivity() {

    // var => mutable

    // val => immutable , in java known as FINAL

    private val SAY_HELLO: String = "Hello Kotlin"

    private val FLAG1: Boolean = false
    private val FLAG2: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = SAY_HELLO
        showToast(SAY_HELLO)
        showToast(SAY_HELLO, "Pratama WIJAYA")
        showToast(SAY_HELLO, "Pratama Wijaya", 2)


        val i: Int = 9
        val d: Double = i.toDouble()

        val c: Char = 'c'
        val x: Int = c.toInt()

        val bitwiseOr = FLAG1 or FLAG2
        val bitwiseAnd = FLAG1 and FLAG2

        val e = 12 // an Int
        val fHex = 0x0f // int from hexadesimal
        val f = 3L // Long
        val g = 4.5 // Double
        val h = 5.6F // Float

        // string can accessed as array
        val s = "Pratama Wijaya"
        val sc = s[3] // a
        val scv = s[4] //t

        for (data in s) Log.d("data", "data -> " + data)

        val person = Person()
        person.name = "Pratama Wijaya"
        val name = person.name
    }

    fun showToast(message: String, tag: String = MainActivity::class.java.getSimpleName(), length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "[$tag] $message", length).show()
    }

}
