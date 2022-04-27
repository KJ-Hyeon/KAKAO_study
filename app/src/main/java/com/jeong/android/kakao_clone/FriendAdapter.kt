package com.jeong.android.kakao_clone

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeong.android.kakao_clone.databinding.FriendItemBinding

class FriendAdapter(val friend_list: ArrayList<Friend>, val context: Context):
    RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {
    private lateinit var binding: FriendItemBinding

    interface OnItemClickListener{
        fun onItemClick(data: Friend, pos: Int )
    }
    private var listener: OnItemClickListener? = null

    fun setonItemClick(listener: OnItemClickListener) {
        this.listener = listener
    }

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

    fun updateItem(pos: Int, name: String) {
        friend_list[pos].name = name
        notifyDataSetChanged()
    }

    inner class FriendViewHolder(private val binding: FriendItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(friend: Friend) {
            binding.friendName.text = friend.name
            binding.friendImage.setImageResource(friend.img)
            val pos = adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                binding.friendContainer.setOnClickListener {
                    listener?.onItemClick(friend,pos)
                }
            }
        }
    }
}