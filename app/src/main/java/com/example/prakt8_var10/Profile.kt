package com.example.prakt8_var10

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

    }
    fun ToMenu(view: View) {

        val intent = Intent(this, Menu::class.java)
        startActivity(intent)
    }

    fun ToLogin(view: View) {

        val intent = Intent(this, Loogin::class.java)
        startActivity(intent)
    }

    fun kishinev(view: View) { val intent = Intent(this, WeatherInfo::class.java)
        intent.putExtra("city", "Кишинев")
        startActivity(intent)}

    fun riga(view: View) {
        val intent = Intent(this, WeatherInfo::class.java)
        intent.putExtra("city", "Рига")
        startActivity(intent)
    }
    fun las_palmas(view: View) { val intent = Intent(this, WeatherInfo::class.java)
        intent.putExtra("city", "Лас-Пальмас")
        startActivity(intent)}

    fun budapesht(view: View) {  val intent = Intent(this, WeatherInfo::class.java)
        intent.putExtra("city", "Будапешт")
        startActivity(intent)}
}