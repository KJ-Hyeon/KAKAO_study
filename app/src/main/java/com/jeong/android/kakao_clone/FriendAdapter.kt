package com.jeong.android.kakao_clone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeong.android.kakao_clone.databinding.FriendItemBinding

class FriendAdapter(val friend_list: ArrayList<Friend>): RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {
    private lateinit var binding: FriendItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        binding = FriendItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FriendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(friend_list[position])
    }

    override fun getItemCount(): Int {
        return friend_list.size
    }

    class FriendViewHolder(private val binding: FriendItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(friend: Friend) {
            binding.friendName.text = friend.name
            binding.friendImage.setImageResource(friend.img)
        }
    }
}