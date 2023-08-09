package com.test.introduceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val idText = findViewById<TextView>(R.id.userId)
        val nameText = findViewById<TextView>(R.id.userName)
        val finishBtn = findViewById<TextView>(R.id.finish)
        val image = findViewById<ImageView>(R.id.main_image)

        if (intent.hasExtra("id")){
            idText.text = intent.getStringExtra("id")
        }
        if (intent.hasExtra("name")){
            nameText.text = intent.getStringExtra("name")
        }

        finishBtn.setOnClickListener{
            finish()
        }

        val id = when((1..6).random()){
            1 -> R.drawable.img1
            2 -> R.drawable.img2
            3 -> R.drawable.img3
            4 -> R.drawable.img4
            5 -> R.drawable.img5
            else -> {R.drawable.img2}
        }
        image.setImageDrawable(ResourcesCompat.getDrawable(resources,id,null))
    }

}