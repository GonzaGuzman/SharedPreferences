package com.zalo.sharedpreferencestwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import com.zalo.sharedpreferencestwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configView()
        binding.btnSaveValue.setOnClickListener {
            SharedApp.prefs.name = binding.etName.text.toString()
            configView() }
        binding.btnDeleteValue.setOnClickListener {
            SharedApp.prefs.name = null
            configView()}
    }

    fun showProfile(){
        binding.tvName.visibility = View.VISIBLE
        binding.tvName.text = "Hola ${SharedApp.prefs.name}"
        binding.btnDeleteValue.visibility = View.VISIBLE
        binding.etName.visibility = View.INVISIBLE
        binding.btnSaveValue.visibility = View.INVISIBLE
    }

    fun showGuest(){
        binding.tvName.visibility = View.INVISIBLE
        binding.btnDeleteValue.visibility = View.INVISIBLE
        binding.etName.visibility = View.VISIBLE
        binding.btnSaveValue.visibility = View.VISIBLE
    }
    fun configView(){
        if(isSavedName()) showProfile() else showGuest()
    }
    fun isSavedName():Boolean{
        val myName = SharedApp.prefs.name
        return myName.toString().isNotEmpty()
    }
}