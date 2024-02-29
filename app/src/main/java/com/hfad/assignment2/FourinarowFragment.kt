package com.hfad.assignment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController

class FourinarowFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_splashscreen, container, false)
        val nextButton = view.findViewById<Button>(R.id.next)
        val textView = view.findViewById<EditText>(R.id.editText)
        nextButton.setOnClickListener{
            val playerName = textView.text.toString()
            val action = FourinarowFragmentDirections.actionFourinarowFragmentToPlayboard()
            view.findNavController().navigate(action)
        }

        return view
    }

}