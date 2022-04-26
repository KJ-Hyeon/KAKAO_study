package com.jeong.android.kakao_clone

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.jeong.android.kakao_clone.databinding.ActivityProfileBinding

class ProfileActivity: AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}