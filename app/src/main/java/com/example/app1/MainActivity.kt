package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = 5
        val b = 10
        Log.i("Informacion","El valor de a es: $a")
        Log.i("Informacion","El valor de a*b es: ${a*b}")
        Log.i("Informacion","lll"${getString())

    }
}