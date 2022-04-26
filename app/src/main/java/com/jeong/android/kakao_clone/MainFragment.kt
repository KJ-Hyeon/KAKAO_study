package com.jeong.android.kakao_clone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jeong.android.kakao_clone.databinding.FragmentMainBinding

class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val friend_list = ArrayList<Friend>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        friend_list.add(Friend("김철수",R.drawable.user_image2))
        friend_list.add(Friend("김맹구",R.drawable.user_image3))
        friend_list.add(Friend("김훈",R.drawable.user_image4))
        friend_list.add(Friend("김유리",R.drawable.user_image5))
        friend_list.add(Friend("김짱구",R.drawable.user_image6))
        friend_list.add(Friend("김철수",R.drawable.user_image2))
        friend_list.add(Friend("김맹구",R.drawable.user_image3))
        friend_list.add(Friend("김훈",R.drawable.user_image4))
        friend_list.add(Friend("김유리",R.drawable.user_image5))
        friend_list.add(Friend("김짱구",R.drawable.user_image6))
        friend_list.add(Friend("김철수",R.drawable.user_image2))
        friend_list.add(Friend("김맹구",R.drawable.user_image3))
        friend_list.add(Friend("김훈",R.drawable.user_image4))
        friend_list.add(Friend("김유리",R.drawable.user_image5))
        friend_list.add(Friend("김짱구",R.drawable.user_image6))

        val adapter = FriendAdapter(friend_list)
        binding.friendRev.adapter = adapter

        return binding.root
    }
}