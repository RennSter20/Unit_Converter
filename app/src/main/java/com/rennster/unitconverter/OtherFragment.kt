package com.rennster.unitconverter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController

class OtherFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_other, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var tempButton: Button? = getView()?.findViewById(R.id.otherButtonTemperature)
        var speedButton:Button? = getView()?.findViewById(R.id.otherButtonSpeed)
        var forceButton:Button? = getView()?.findViewById(R.id.otherButtonForce)
        var timeButton:Button? = getView()?.findViewById(R.id.otherButtonTime)


        tempButton?.setOnClickListener(){
            findNavController().navigate(R.id.action_otherFragment_to_temperatureFragment)
        }

        speedButton?.setOnClickListener(){
            findNavController().navigate(R.id.action_otherFragment_to_speedFragment)
        }

        forceButton?.setOnClickListener(){
            findNavController().navigate(R.id.action_otherFragment_to_forceFragment)
        }

        timeButton?.setOnClickListener(){
            findNavController().navigate(R.id.action_otherFragment_to_timeFragment)
        }
    }
}