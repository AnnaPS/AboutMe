package com.novadev.aboutme

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.novadev.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

private lateinit var binding : ActivityMainBinding
    private val myName: MyName = MyName(name = "Beyoncé Giselle Knowles-Carter")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        bt_done.setOnClickListener {
            addNickName(it)
        }

    }

    private fun addNickName(view: View){

        binding.apply {
            myName?.nickname = edNickname.toString()
            invalidateAll()
        }
        tv_nickname.text = ed_nickname.text
        ed_nickname.visibility = View.GONE
        view.visibility = View.GONE
        tv_nickname.visibility = View.VISIBLE

        // Hide the keyboard
        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken,0)
    }
}
