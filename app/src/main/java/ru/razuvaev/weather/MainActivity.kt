package ru.razuvaev.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import ru.razuvaev.weather.R

class MainActivity : AppCompatActivity() {

    private lateinit var mTextWelcome: TextView
    private lateinit var mButton: MaterialButton
    private lateinit var mTextDataClassOne: TextView
    private lateinit var mTextDataClassTwo: TextView
    private lateinit var mBtnDCExample: MaterialButton
    private lateinit var mTextCat: TextView
    private lateinit var mListTextCatCopy: TextView
    private lateinit var mBtnObj: MaterialButton

    private var mDataExample = DataExample("First text", "Second text")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setView()
        setListener()
        setClassObject()
    }

    private fun setView() {
         mTextWelcome = findViewById(R.id.text_welcome)
         mButton = findViewById(R.id.button_one)
         mTextDataClassOne = findViewById(R.id.data_text1)
         mTextDataClassTwo = findViewById(R.id.data_text2)
         mBtnDCExample = findViewById(R.id.data_class_button)
         mTextCat = findViewById(R.id.lst_cats)
         mBtnObj = findViewById(R.id.object_class_button)
         mListTextCatCopy = findViewById(R.id.lst_cats_copy)
    }

    private fun setListener() {

        mButton.setOnClickListener { mTextWelcome.text = "Добро пожаловать в мир Котлин" }
        mBtnDCExample.setOnClickListener {
            mTextDataClassOne.text = mDataExample.text1
            mTextDataClassTwo.text = mDataExample.text2
        }
         mBtnObj.setOnClickListener {
            mDataExample = mDataExample.copy(text2 = "copy TEXT")
            val copyText = "%s\n%s"
            mListTextCatCopy.text = String.format(copyText, mDataExample.text1, mDataExample.text2)
        }
    }

    private fun setClassObject() {
        MyObject.mNameCats.add("Barsik")
        MyObject.mNameCats.add("Murka")
        MyObject.mNameCats.add("Sonya")
        mTextCat.text = MyObject.callCats()
    }
}