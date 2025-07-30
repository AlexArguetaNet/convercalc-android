package com.example.convercalc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationViewMain: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bottomNavigationViewMain = findViewById(R.id.bottom_navigation_main)
        bottomNavigationViewMain.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.menu_item_distance -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view_main, FragmentDistance())
                        .commit()
                }
                R.id.menu_item_weight -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view_main, FragmentWeight())
                        .commit()

                }
            }

            true
        }



    }// End of onCreate
}