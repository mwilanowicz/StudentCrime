package com.example.lista2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        view.findViewById<TextView>(R.id.crimeTitle).text = arguments?.getString("TITLE")
        view.findViewById<TextView>(R.id.crimeDetails).text = arguments?.getString("DETAILS")
        val isSolved = arguments?.getBoolean("ISSOLVED")
        if(isSolved != null){
            if(isSolved){
                view.findViewById<ImageView>(R.id.solveIcon).setImageResource(R.drawable.ic_solved)
            }
            else{
                view.findViewById<ImageView>(R.id.solveIcon).setImageResource(R.drawable.ic_notsolved)
            }
        }
        val button = view.findViewById<Button>(R.id.returnButton)
        button.setOnClickListener{
            findNavController().navigate(R.id.action_detailFragment_to_listFragment)
        }
        return view
    }
}