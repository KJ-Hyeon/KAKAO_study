package com.jeong.android.kakao_clone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jeong.android.kakao_clone.databinding.FragmentElseBinding
import com.jeong.android.kakao_clone.databinding.FragmentShopBinding

class ElseFragment: Fragment() {

    private lateinit var binding: FragmentElseBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentElseBinding.inflate(inflater, container, false)
        return binding.root
    }
}