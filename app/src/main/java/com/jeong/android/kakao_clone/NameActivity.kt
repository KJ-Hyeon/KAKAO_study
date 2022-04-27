package com.jeong.android.kakao_clone

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jeong.android.kakao_clone.databinding.ActivityNameBinding

class NameActivity: AppCompatActivity() {

    private lateinit var binding: ActivityNameBinding
    private var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        name = intent.getStringExtra("name")

        initState()

        binding.tvOk.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("update_name",binding.nameEdit.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        binding.btnCancle.setOnClickListener {
            finish()
        }

        binding.btnClear.setOnClickListener {
            binding.nameEdit.text = null
        }

        binding.nameEdit.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // 입력하기 전에 작동된다
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //타이핑 되는 텍스트에 변화가 있을때 작동 된다
                val input = binding.nameEdit.text.toString()
                binding.tvLength.text = "${input.length}/20"
                if (input.isEmpty()) {
                    binding.btnClear.visibility = View.GONE
                } else {
                    binding.btnClear.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                //입력이 끝날때 작동된다
            }
        })
    }

    private fun initState() {
        binding.nameEdit.hint = name
        binding.nameEdit.setText(name)
        binding.tvLength.text = "${name?.length}/20"
        binding.setName.text = "친구가 설정한 이름: $name"
    }
}