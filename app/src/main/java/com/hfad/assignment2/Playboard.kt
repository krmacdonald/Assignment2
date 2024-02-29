package com.hfad.assignment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Playboard : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_playboard, container, false)
        val textView = view.findViewById<TextView>(R.id.userNameText)
        val playerName = PlayboardArgs.fromBundle(requireArguments()).playerName
        textView.text = "It is currently $playerName's turn"
        return view
    }



}