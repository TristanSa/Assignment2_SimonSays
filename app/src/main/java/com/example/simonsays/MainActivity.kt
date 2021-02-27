package com.example.simonsays

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Define needed variables
        var random:Int = (0..3).random()
        val fourColors: Array<String> = arrayOf("Green","Yellow","Blue","Red")
        val allColors: ArrayList<String> = arrayListOf(fourColors[random])
        val start: Button = findViewById<Button>(R.id.StartBtn)
        val activitiesArray: Array<Class<out AppCompatActivity>> = arrayOf(Green::class.java, Yellow::class.java, Blue::class.java, Red::class.java)

        //Colors simon Says
        for(i:Int in 0..3){
            random = (0..3).random()
            allColors.add(fourColors[random])
        }

        //Start button to create the game
        start.setOnClickListener {
            val intent = Intent(this@MainActivity, activitiesArray[random])
            intent.putStringArrayListExtra("colors", allColors)
            intent.putExtra("count",0)
            intent.putExtra("score",0)
            startActivity(intent)
        }
    }
}
//Reference: https://www.youtube.com/watch?v=I-T_A9tnhgQ&t=59s

