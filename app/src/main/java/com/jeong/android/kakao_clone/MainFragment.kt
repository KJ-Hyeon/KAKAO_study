package com.jeong.android.kakao_clone

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.jeong.android.kakao_clone.databinding.FragmentMainBinding

class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val friend_list = ArrayList<Friend>()
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    var change_pos: Int = 0
    var update_name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG","FRAGOncreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        Log.e("TAG","fragment호출")
        friend_list.add(Friend("김철수",R.drawable.user_image2))
        friend_list.add(Friend("김맹구",R.drawable.user_image3))
        friend_list.add(Friend("김훈",R.drawable.user_image4))
        friend_list.add(Friend("김유리",R.drawable.user_image5))
        friend_list.add(Friend("김짱구",R.drawable.user_image6))

        val adapter = FriendAdapter(friend_list,requireContext())
        binding.friendRev.adapter = adapter

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ activityResult ->
            if (activityResult.resultCode == Activity.RESULT_OK) {
                Log.e("RESULT","결과값받기 호출")
                if (!activityResult.data?.getStringExtra("update_name").isNullOrEmpty()) {
                    Log.e("RESULT","결과값받기 호출")
                    update_name = activityResult.data?.getStringExtra("update_name")
                    update_name?.let {
                        adapter.updateItem(change_pos, it)
                    }
                }
            }
        }

        adapter.setonItemClick(object : FriendAdapter.OnItemClickListener{
            override fun onItemClick(data: Friend, pos: Int) {
                change_pos = pos
                val intent = Intent(requireContext(),ProfileActivity::class.java)
                intent.putExtra("name",friend_list[pos].name)
                intent.putExtra("img",friend_list[pos].img)
                activityResultLauncher.launch(intent)
            }
        })
        return binding.root
    }
}