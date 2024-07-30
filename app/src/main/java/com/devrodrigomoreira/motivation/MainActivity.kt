package com.devrodrigomoreira.motivation

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.devrodrigomoreira.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        handleUserName()
        // evento de click
        binding.buttonNewPhrase.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_new_phrase) {
            var s = ""
        }
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getKey("USER_NAME")
        val greeting = getString(R.string.greeting)
        binding.textUserName.text = "$greeting, $name!"
    }
}