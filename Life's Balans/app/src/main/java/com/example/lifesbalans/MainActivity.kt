package com.example.lifesbalans

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var balance: Int = 100
    var count: Int = 0
    var new_cont: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getPreferences(Context.MODE_PRIVATE)
        var countGet = pref.getInt("COUNT", 0)

        balance = countGet

        textView.setText(balance.toString())

        numberPicker.minValue = 0
        numberPicker.maxValue = 100
        numberPicker.value = 50
        new_cont = 50
        numberPicker.wrapSelectorWheel = false


        numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            new_cont = newVal
        }

        button.setOnClickListener() {
            if (checkBox.isChecked()) {

                balance = count - new_cont
                textView.text = "$balance"
                count = balance

            } else {

                balance = count + new_cont
                textView.text = "$balance"
                count = balance

            }

            textView.text = "$balance"

            onSave()
        }

        plusten.setOnClickListener() {
            balance = count + 10
            textView.text = "$balance"
            count = balance
            onSave()
        }

        plustwenty.setOnClickListener() {
            balance = count + 20
            textView.text = "$balance"
            count = balance
            onSave()
        }

        minushundred.setOnClickListener() {
            balance = count - 100
            textView.text = "$balance"
            count = balance
            onSave()
        }
    }

    private fun onSave(){

        var pref = getPreferences(Context.MODE_PRIVATE)
        var editor = pref.edit()

        editor.putInt("COUNT", textView.toString().toInt())

        editor.commit()

        var toast = Toast.makeText(applicationContext, "Saved", Toast.LENGTH_LONG)
        toast.show()
    }
}

