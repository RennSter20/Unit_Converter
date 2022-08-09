package com.example.unitconverter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout

/**
 * A simple [Fragment] subclass.
 * Use the [LenghtFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LenghtFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lenght, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lenght = resources.getStringArray(R.array.lenght_first)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, lenght)
        getView()?.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)?.setAdapter(arrayAdapter)
        getView()?.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView2)?.setAdapter(arrayAdapter)

        var inputLenghtUser = getView()?.findViewById<EditText>(R.id.editTextNumberDecimal)
        var calculateButton = getView()?.findViewById<Button>(R.id.button)
        var resultText: TextView? = getView()?.findViewById(R.id.result)

        if (calculateButton != null) {
            calculateButton.setOnClickListener(){
                var inputDouble:Double = inputLenghtUser.text.
            }
        }
    }
}