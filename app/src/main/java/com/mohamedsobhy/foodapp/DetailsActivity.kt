package com.mohamedsobhy.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        imageView.setImageResource(intent.getIntExtra("image" , R.drawable.ic_launcher_background))
        coffeeName.text = intent.getStringExtra("name")
        coffeeDiscription.text = intent.getStringExtra("description")
    }
}