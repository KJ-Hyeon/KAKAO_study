package com.jeong.android.kakao_clone

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.jeong.android.kakao_clone.databinding.ActivityProfileBinding

class ProfileActivity: AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    var update_name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra("name")
        val img = intent.getIntExtra("img",0)

        binding.tvName.text = name
        binding.ivProfile.setImageResource(img)

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK) {
                if (!it.data?.getStringExtra("update_name").isNullOrEmpty()) {
                    update_name = it.data?.getStringExtra("update_name")
                    binding.tvName.text = update_name
                }
            }
        }

        binding.nameLine.setOnClickListener {
            val intent = Intent(this, NameActivity::class.java)
            intent.putExtra("name",binding.tvName.text.toString())
            activityResultLauncher.launch(intent)
        }

        binding.btnFinish.setOnClickListener {
            val result = Intent().apply {
                putExtra("update_name",update_name)
            }
            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }
}
