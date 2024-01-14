package com.example.animalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.animalapp.base.BaseActivity
import com.example.animalapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun prepareView(savedInstanceState: Bundle?) {
        val kotlinVersion = KotlinVersion.CURRENT
        Log.d("CHECK", kotlinVersion.toString())
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navHostContainerView)
        return  navController.navigateUp() || super.onSupportNavigateUp()
    }
    

}