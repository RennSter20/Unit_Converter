package com.rennster.unitconverter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class WeightFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weight, container, false)
    }

    override fun onResume() {
        super.onResume()
        val lenght = resources.getStringArray(R.array.weight_measures)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, lenght)
        getView()?.findViewById<AutoCompleteTextView>(R.id.weightAutoCompleteTextView)?.setAdapter(arrayAdapter)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lenght = resources.getStringArray(R.array.weight_measures)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, lenght)
        getView()?.findViewById<AutoCompleteTextView>(R.id.weightAutoCompleteTextView)?.setAdapter(arrayAdapter)

        var spinner = getView()?.findViewById<AutoCompleteTextView>(R.id.weightAutoCompleteTextView)

        var button: Button? = getView()?.findViewById(R.id.button2)
        var text:TextView? = getView()?.findViewById<TextView>(R.id.textView2)

        var selectedItem:String? = null

        spinner?.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            selectedItem = parent.getItemAtPosition(position) as String
        })

        button?.setOnClickListener(){
            text?.text = selectedItem
        }

    }

}