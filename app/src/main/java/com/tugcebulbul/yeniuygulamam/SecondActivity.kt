package com.tugcebulbul.yeniuygulamam

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tugcebulbul.yeniuygulamam.databinding.ActivityMainBinding
import com.tugcebulbul.yeniuygulamam.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //diğer aktiviteden bu aktiviteye geçiş
        binding.textView2.text = "Kullanıcı İsmi : ${intent.getStringExtra("isim")?.uppercase()}"
        //uyarı bildirimi
        Toast.makeText(this@SecondActivity, "Tebrikler kaydınız tamamlanmıştır!!", Toast.LENGTH_LONG).show()
    }
}