package com.example.unitconverter

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar


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

        var spinner = getView()?.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)

        var textKilo: TextView? = getView()?.findViewById(R.id.lenght_kilo_result)
        var textMeter:TextView? = getView()?.findViewById(R.id.lenght_meter_result)
        var textDeci:TextView? = getView()?.findViewById(R.id.lenght_decimeter_result)
        var textCenti:TextView? = getView()?.findViewById(R.id.lenght_centimeter_result)

        var selectedItem:String? = null

        spinner?.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
            selectedItem = parent.getItemAtPosition(position) as String
        })

        var inputLenghtUser = getView()?.findViewById<EditText>(R.id.editTextNumberDecimal)
        var calculateButton = getView()?.findViewById<Button>(R.id.button)

        fun largeNumber(number:Double) :Boolean{
            var bool:Boolean = false

            if(number > 1000){
                bool = true
            }

            return bool
        }

        fun setText(selectedItem:String):Boolean {
            when{
                selectedItem.equals("Kilometer") -> {
                    textKilo?.text = inputLenghtUser?.text.toString()
                    textMeter?.text = (inputLenghtUser?.text.toString().toDouble() * 1000).toString()
                    textDeci?.text = (inputLenghtUser?.text.toString().toDouble() * 10000).toString()
                    textCenti?.text = (inputLenghtUser?.text.toString().toDouble() * 100000).toString()
                }

                selectedItem.equals("Meter") -> {
                    textKilo?.text = ((inputLenghtUser?.text.toString().toDouble() * 0.001).toString())
                    textMeter?.text = inputLenghtUser?.text.toString()
                    textDeci?.text = (inputLenghtUser?.text.toString().toDouble() * 10).toString()
                    textCenti?.text = (inputLenghtUser?.text.toString().toDouble() * 100).toString()
                }
            }
            return true

        }

            calculateButton?.setOnClickListener(){
                var inputDouble:Double? = null
                    if(inputLenghtUser?.text.isNullOrEmpty()){
                        var view: View? = activity?.findViewById(android.R.id.content)
                        Snackbar.make(view!!, "Please enter lenght.", Snackbar.LENGTH_SHORT).show()
                    }else{

                            if(setText(selectedItem.toString())){
                                Snackbar.make(requireView(), "Your lenght has been calculated!", Snackbar.LENGTH_SHORT).show()
                            }

                    }
            }


        
    }



}