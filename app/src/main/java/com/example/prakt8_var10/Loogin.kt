package com.example.prakt8_var10

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Loogin : AppCompatActivity() {
    private val APP_PREFERENCES = "mysettings"
    private val PREF_PASSWORD="mypass"
    private val PREF_EMAIL="myemail"
    lateinit var pass: EditText
    lateinit var email:EditText
    lateinit var pref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loogin)
        pass = findViewById(R.id.editTextTextPassword);
        email = findViewById(R.id.editTextTextEmailAddress);
        pref=getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
    }

    //сохранение почты и пароля
    fun setPreference(view: View) {
        val message = AlertDialog.Builder(this)
        message.setTitle("Сообщение")
        message.setMessage("Сохранить профиль?")
        message.setPositiveButton("OK", DialogInterface.OnClickListener{ dialog, which->
            val passwords = pass.text.toString()
            val post = email.text.toString()
            if (passwords!=""&& post!="") {
                val prefEditor = pref.edit()
                prefEditor.putString(PREF_PASSWORD, passwords)
                prefEditor.putString(PREF_EMAIL, post)
                prefEditor.apply()
                val text = "Данные для входа зарегестрированы!"
                val duration = Toast.LENGTH_SHORT
                Toast.makeText(applicationContext, text, duration).show()
            }
            else {
                val text = "Найдены пустые поля!"
                val duration = Toast.LENGTH_SHORT
                Toast.makeText(applicationContext, text, duration).show()
            }
        })
        message.setNegativeButton("Oтмена", DialogInterface.OnClickListener{ dialog, which->
            val text = "Сохранение отменено!"
            val duration = Toast.LENGTH_SHORT
            Toast.makeText(applicationContext, text , duration).show()
        })
        val dialog=message.create()
        message.show()
    }

    //проверка правильности ввода почты и пароля
    fun getPref(view: View) {
        val inputpassword=pass.text.toString()
        val inputemail = email.text.toString()
        val savepassword=pref.getString(PREF_PASSWORD,"")
        val saveemail=pref.getString(PREF_EMAIL,"")
        if (inputpassword==savepassword && inputemail==saveemail && inputpassword!="" && inputemail!="") {
            pass.setText(savepassword)
            email.setText(saveemail)
            val text = "Успешный вход!"
            val duration = Toast.LENGTH_SHORT
            Toast.makeText(applicationContext, text , duration).show()
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
            finish()
        }
        else
        {
            val text = "Введены не правильные данные при входе!"
            val duration = Toast.LENGTH_SHORT
            Toast.makeText(applicationContext, text , duration).show()
        }
    }
}