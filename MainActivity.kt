package com.example.selfproject4_420210814

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import com.example.selfproject4_420210814.R

class MainActivity : AppCompatActivity() {

    private lateinit var switchStart: Switch
    private lateinit var choiceLayout: LinearLayout
    private lateinit var radioGroup: RadioGroup
    private lateinit var imageView: ImageView
    private lateinit var buttonExit: Button
    private lateinit var buttonReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchStart = findViewById(R.id.switchStart)
        choiceLayout = findViewById(R.id.choiceLayout)
        radioGroup = findViewById(R.id.radioGroup)
        imageView = findViewById(R.id.imageView)
        buttonExit = findViewById(R.id.buttonExit)
        buttonReset = findViewById(R.id.buttonReset)


        switchStart.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switchStart.text = "시작함"
                choiceLayout.visibility = View.VISIBLE
            } else {
                switchStart.text = "시작"
                choiceLayout.visibility = View.GONE
                resetChoices()
            }
        }

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioOreo -> {
                    imageView.setImageResource(R.drawable.oreo)
                }
                R.id.radioPie -> {
                    imageView.setImageResource(R.drawable.pie)
                }
                R.id.radioQ -> {
                    imageView.setImageResource(R.drawable.q10)
                }
            }
        }

        buttonExit.setOnClickListener {
            finish()
        }

        buttonReset.setOnClickListener {
            switchStart.isChecked = false
            resetChoices()
        }
    }

    private fun resetChoices() {
        radioGroup.clearCheck()
        imageView.setImageResource(0)
    }
}
