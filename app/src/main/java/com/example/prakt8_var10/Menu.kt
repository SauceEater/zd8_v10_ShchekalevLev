package com.example.prakt8_var10

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.Toast

class Menu : AppCompatActivity() {
    private lateinit var CityList: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private val cities = mutableListOf("Кишинев", "Рига", "Лас-Пальмас", "Будапешт")

    override fun onCreate(savedInstanceState: Bundle?) {//открывает activity_menu
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        CityList = findViewById(R.id.listView)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cities)
        CityList.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId)// Проверяем значение itemId выбранного пункта меню
            {
            R.id.menu_add -> {
                showAddCityDialog()// Вызываем функцию для отображения диалогового окна добавления города
                return true // Возвращаем true, чтобы указать, что пункт меню был успешно обработан
            }
            else -> return super.onOptionsItemSelected(item)// Если значение itemId не соответствует ожидаемому, передаем его классу для обработки
        }
    }


    fun showMenu(view: View)
    {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.menu)

        popupMenu.setOnMenuItemClickListener { item ->
            onOptionsItemSelected(item)
        }

        popupMenu.show()
    }

    private fun showAddCityDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_add_city)
        dialog.window?.setLayout(//Установка размера окна добавления города
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
            /////////////////////
        val Naz = dialog.findViewById<EditText>(R.id.naz)
        val btnAdd = dialog.findViewById<Button>(R.id.btn_add)

        btnAdd.setOnClickListener {
            val naz = Naz.text.toString().trim()// trim удаляет пробелы в начале и в конце

            if (naz.isNotEmpty()) {

                cities.add(naz)
                adapter.notifyDataSetChanged()// обновление списка

                Toast.makeText(this, "Вы добавили город", Toast.LENGTH_SHORT).show()
                dialog.dismiss()// закрывает окно добавления города
            } else {
                Toast.makeText(this, "Введите название города", Toast.LENGTH_SHORT).show()
            }
        }
        dialog.show()//даёт возможность открыть диалоговое окно (добавление города)
    }
}