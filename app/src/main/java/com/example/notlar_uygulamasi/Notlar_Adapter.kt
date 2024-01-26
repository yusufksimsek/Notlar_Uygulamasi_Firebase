package com.example.notlar_uygulamasi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.notlar_uygulamasi.databinding.CardTasarimBinding

class Notlar_Adapter(private val mcontext:Context,private val notlarListe:List<Notlar>) :
    RecyclerView.Adapter<Notlar_Adapter.CardTasarimTutucu>()
{

    inner class CardTasarimTutucu(private val binding: CardTasarimBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(not:Notlar){
            binding.tvDers.text = not.ders_adi
            binding.tvNot1.text = not.not1.toString()
            binding.tvNot2.text = not.not2.toString()

            binding.notCard.setOnClickListener {
                val intent = Intent(mcontext,DetayActivity::class.java)
                intent.putExtra("nesne",not)
                mcontext.startActivity(intent)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return notlarListe.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        holder.bind(notlarListe[position])
    }
}