package com.example.prakt8_var10

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class WeatherInfo : AppCompatActivity() {
    private lateinit var cityTextView: TextView
    private lateinit var temperatureTextView: TextView
    private lateinit var windTextView: TextView
    private lateinit var AverageTemperature: TextView
    private lateinit var weatherImageView: ImageView

    private fun setWeatherData(city: String) {
        val temperature: String = when (city) {
            "Кишинев" -> "Температура: 21°C"
            "Рига" -> "Температура: 32°C"
            "Лас-Пальмас" -> "Температура: 13°C"
            "Будапешт" -> "Температура: 44°C"
            else -> "N/A"
        }

        val wind: String = when (city) {
            "Кишинев" -> "Скорость ветра: 21 (м/с)"
            "Рига" -> "Скорость ветра: 100 (м/с)"
            "Лас-Пальмас" -> "Скорость ветра: 5м/с)"
            "Омск" -> "Скорость ветра: 42 (м/с)"
            else -> "N/A"
        }

        val AverTempeature: String = when (city) {
            "Кишинев" -> "Зима: -8°C\n Осень: 14°C\n Лето: 200°C\n Весна: 100°C"
            "Рига" -> "Зима: -42°C\n Осень: -10°C\n Лето: 0°C\n Весна: -6°C"
            "Лас-Пальмас" -> "Зима: 23°C\n Осень: 32°C\n Лето: 44°C\n Весна: 21°C"
            "Будапешт" -> "Зима: 20°C\n Осень: 32°C\n Лето: 55°C\n Весна: 65°C"
            else -> "N/A"
        }

        temperatureTextView.text = temperature
        windTextView.text = wind
        AverageTemperature.text = AverTempeature

        val imageResource: Int = when (city) {
            "Кишинев" -> R.drawable.weather_1_kishinev
            "Рига" -> R.drawable.weather_2_riga
            "Лас-Пальмас" -> R.drawable.weather_3_las_palmas
            "Будапешт" -> R.drawable.weather_4_budapesht

            else -> R.drawable.weather_default
        }
        weatherImageView.setImageResource(imageResource)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_info)

        cityTextView = findViewById(R.id.textView4)
        temperatureTextView = findViewById(R.id.textView8)
        windTextView = findViewById(R.id.textView)
        AverageTemperature = findViewById(R.id.textView9)
        weatherImageView = findViewById(R.id.imageView4)


        var city = intent.getStringExtra("city")
        cityTextView.text = city.toString()

        if (city != null) {
            setWeatherData(city)
        }
    }
}