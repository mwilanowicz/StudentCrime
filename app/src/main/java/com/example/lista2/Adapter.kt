package com.example.lista2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val crimeList: MutableList<Crime>) : RecyclerView.Adapter<Adapter.CrimeListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeListViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.adapter, parent, false)
        return CrimeListViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: CrimeListViewHolder, position: Int) {
        val currentItem = crimeList[position]

        holder.title.text = currentItem.title

        if(currentItem.isSolved)
            holder.solvedIcon.setImageResource(R.drawable.ic_solved)
        else
            holder.solvedIcon.setImageResource(R.drawable.ic_notsolved)

    }

    override fun getItemCount(): Int = crimeList.size

    inner class CrimeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.tv_title)
        val solvedIcon = itemView.findViewById<ImageView>(R.id.imageViewSolved)


        init{
            itemView.setOnClickListener{
                val dataBundle = Bundle()
                dataBundle.putString("TITLE", crimeList[adapterPosition].title)
                dataBundle.putString("DETAILS", crimeList[adapterPosition].description)
                dataBundle.putBoolean("ISSOLVED", crimeList[adapterPosition].isSolved)

                Navigation.findNavController(itemView).navigate(R.id.action_listFragment_to_detailFragment, dataBundle)

            }
        }
    }

}