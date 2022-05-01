package com.jeong.android.kakao_clone

import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.jeong.android.kakao_clone.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private val search_friend_list = ArrayList<Friend>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.searchRev.visibility = View.GONE

        search_friend_list.add(Friend("김철수",R.drawable.user_image2))
        search_friend_list.add(Friend("한맹구",R.drawable.user_image3))
        search_friend_list.add(Friend("박훈",R.drawable.user_image4))
        search_friend_list.add(Friend("차유리",R.drawable.user_image5))
        search_friend_list.add(Friend("이짱구",R.drawable.user_image6))

        val adapter = FriendAdapter(search_friend_list)
        binding.searchRev.adapter = adapter

        binding.tvFriend.setOnClickListener {

        }
        binding.searchEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("ChangedCheck","onTextChanged실행")
                adapter.FriendFilter().filter(p0)

            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }
}
// Filter가 안되기 때문에 리사이클러뷰의 Filter가 아닌 코드로 검색하는 기능을 만들어봐야할듯