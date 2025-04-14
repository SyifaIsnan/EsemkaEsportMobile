package com.example.esemkaesport

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.esemkaesport.databinding.ActivityTimBinding

class TimPemain : AppCompatActivity() {

    private lateinit var binding: ActivityTimBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tim)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityTimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchView.addTextChangedListener(
            object : TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    filter(s.toString(), listTim)
                }

            }
        )



    }

    private fun filter(string: String, listTim: MutableList<TimModel>) {
        val newList = mutableListOf<TimModel>()
        for(tim in listTim){
            if(tim.name.contains(string, ignoreCase = true)){
                newList.add(tim)
            }
        }
        runOnUiThread {
            binding.frameLayout. = GridLayoutManager(this@Home, 2)
            binding.frameLayout.adapter = TimAdapter(newList, this@Home)
        }
    }
}