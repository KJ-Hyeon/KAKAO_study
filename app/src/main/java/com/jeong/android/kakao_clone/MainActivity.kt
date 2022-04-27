package com.jeong.android.kakao_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jeong.android.kakao_clone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e("TAG","MAIN호출")

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottmo_nav)
        val navController = supportFragmentManager.findFragmentById(R.id.main_frame_container)?.findNavController()
        navController?.let {
            // 바텀네비게이션 과 네비게이션 컨트롤? 을 묶어주는 역할
            bottomNavigation.setupWithNavController(it)
        }
    }

    override fun onPause() {
        super.onPause()
        binding.layoutBlur.visibility = View.VISIBLE
        binding.logo.visibility = View.VISIBLE
        Log.e("TAG","onPause호출")
    }

    override fun onResume() {
        super.onResume()
        binding.layoutBlur.visibility = View.INVISIBLE
        binding.logo.visibility = View.INVISIBLE
        Log.e("TAG","onResume호출")
    }

    override fun onStart() {
        super.onStart()
        Log.e("TAG","onStart호출")
        // 이름바꾸는 과정에서 다시 돌아오면 여기가 실행 받아온 값으로
    }

    override fun onStop() {
        super.onStop()
        Log.e("TAG","onStop호출")
    }
}