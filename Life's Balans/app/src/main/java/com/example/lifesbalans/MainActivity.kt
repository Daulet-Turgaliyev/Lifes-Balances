package com.example.lifesbalans

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.util.Log.i
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var balance:Int = 100
    var count:Int = 0
    var new_cont:Int = 0


    var sharedPref: SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userId: String? = sharedPref?.getString("myPref", "default if empty")
        if(userId != null){

            textView.text = userId.toString()

        }
        numberPicker.minValue = 0
        numberPicker.maxValue = 100
        numberPicker.value = 50
        numberPicker.wrapSelectorWheel = false

        numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            new_cont = newVal
        }

        button.setOnClickListener(){
            if(checkBox.isChecked()){

                balance = count - new_cont
                textView.text = "$balance"
                count = balance

            }
            else
            {

                balance = count + new_cont
                textView.text = "$balance"
                count = balance

            }

            textView.text = "$balance"
        }

        plusten.setOnClickListener(){
            balance = count + 10
            textView.text = "$balance"
            count = balance

            val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE);
            sharedPref.edit().putString("myPref", balance.toString()).apply()

        }

        plustwenty.setOnClickListener(){
            balance = count + 20
            textView.text = "$balance"
            count = balance
        }

        minushundred.setOnClickListener(){
            balance = count - 100
            textView.text = "$balance"
            count = balance
        }
    }


}

