package com.jeong.android.kakao_clone

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.jeong.android.kakao_clone.databinding.FriendItemBinding

class FriendAdapter(var friend_list: ArrayList<Friend>):
    RecyclerView.Adapter<FriendAdapter.FriendViewHolder>(){

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

    inner class FriendFilter: Filter() {
        override fun performFiltering(p0: CharSequence): FilterResults {
            Log.e("Filter1st","filter실행")
            val filterString = p0.toString()
            val result = FilterResults()

            val friend_list_filtered = ArrayList<Friend>()
            if (filterString.isEmpty()){
                result.values = friend_list
                result.count = friend_list.size
                return result
            } else {
                for (friend in friend_list) {
                    Log.e("Filter","$friend")
                    if (friend.name == filterString) {
                        Log.e("Filter","add실행")
                        friend_list_filtered.add(friend)
                    }
                }
            }
            result.values = friend_list_filtered
            result.count = friend_list_filtered.size
            return result
        }

        override fun publishResults(p0: CharSequence?, p1: FilterResults) {
            Log.e("Filter2st","filter실행")
            friend_list.clear()
//            friend_list.addAll(p1.values as ArrayList<Friend>)
            friend_list = p1.values as ArrayList<Friend>
            notifyDataSetChanged()
        }
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