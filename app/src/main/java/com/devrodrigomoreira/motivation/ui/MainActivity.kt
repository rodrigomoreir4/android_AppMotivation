package com.devrodrigomoreira.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.devrodrigomoreira.motivation.infra.MotivationConstants
import com.devrodrigomoreira.motivation.R
import com.devrodrigomoreira.motivation.data.Mock
import com.devrodrigomoreira.motivation.infra.SecurityPreferences
import com.devrodrigomoreira.motivation.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        handleUserName()
        handleFilter(R.id.image_all)
        handleNextPhrase()

        // Eventos
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_new_phrase) {
            handleNextPhrase()
        } else if (v.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_sunny)){
            handleFilter(v.id)
        }
    }

    private fun handleNextPhrase(){
        val phrase = Mock().getPhrase(categoryId, Locale.getDefault().language)
        binding.textText.text = phrase
    }
    private fun handleFilter(id: Int){

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.image_happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.HAPPY
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getKey(MotivationConstants.KEY.USER_NAME)
        val greeting = getString(R.string.greeting)
        binding.textUserName.text = "$greeting, $name!"
    }
}