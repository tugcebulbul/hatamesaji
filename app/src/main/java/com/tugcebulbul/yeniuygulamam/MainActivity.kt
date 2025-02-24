package com.tugcebulbul.yeniuygulamam

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tugcebulbul.yeniuygulamam.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun sonrakiSayfa(view:View){
        val kullaniciGirisi = binding.editTextText.text.toString()
        if (kullaniciGirisi.isEmpty()){
            Toast.makeText(this, "Lütfen isminizi giriniz", Toast.LENGTH_LONG).show()
            return
        }
        //uyarı penceresi
        val alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Sonraki sayfa")
        //uyarı mesajı
        alert.setMessage("Sonraki sayfaya geçmek istediğinize emin misiniz?")
        //pozitif cevap
        alert.setPositiveButton("Evet") { dialog, which ->
            Toast.makeText(this, "Kayıt edildi", Toast.LENGTH_LONG).show()

            //diğer aktiviteye geçiş
            val intent = Intent(this, SecondActivity :: class.java)
            intent.putExtra("isim",kullaniciGirisi)
            startActivity(intent)

        }

        // negatif cevap
        alert.setNegativeButton("Hayır",object : DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                Toast.makeText(this@MainActivity, "Kayıt iptal edildi", Toast.LENGTH_LONG).show()
            }
        })
        alert.show()

    }

}