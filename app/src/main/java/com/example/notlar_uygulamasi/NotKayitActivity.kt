package com.example.notlar_uygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.notlar_uygulamasi.databinding.ActivityMainBinding
import com.example.notlar_uygulamasi.databinding.ActivityNotKayitBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class NotKayitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotKayitBinding
    private lateinit var refNotlar: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotKayitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarNotKayit.title = "Not Kayit"
        setSupportActionBar(binding.toolbarNotKayit)

        val db = FirebaseDatabase.getInstance()
        refNotlar = db.getReference("notlar")

        binding.btnKaydet.setOnClickListener {
            val ders_adi = binding.etDers.text.toString().trim()
            val not1 = binding.etNot1.text.toString().trim()
            val not2 = binding.etNot2.text.toString().trim()

            if(TextUtils.isEmpty(ders_adi)){
                Snackbar.make(binding.toolbarNotKayit,"Ders Adini Giriniz",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(TextUtils.isEmpty(not1)){
                Snackbar.make(binding.toolbarNotKayit,"1.Notu Giriniz",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(TextUtils.isEmpty(not2)){
                Snackbar.make(binding.toolbarNotKayit,"2.Notu Giriniz",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val not = Notlar("",ders_adi,not1.toInt(),not2.toInt())
            refNotlar.push().setValue(not)

            startActivity(Intent(this@NotKayitActivity,MainActivity::class.java))
            finish()
        }

    }
}