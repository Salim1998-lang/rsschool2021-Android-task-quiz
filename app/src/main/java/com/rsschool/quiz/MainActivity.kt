package com.rsschool.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.rsschool.quiz.data.*
import com.rsschool.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ActivityNavigate {

    private lateinit var navController: NavController
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(activityMainBinding.navHostFragment.id) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
        q1 = -1
        q2 = -1
        q3 = -1
        q4 = -1
        q5 = -1
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun intentOnShareResult() {
        startActivity(Intent(this, ShareResultActivity::class.java))
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}