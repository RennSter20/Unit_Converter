package com.rennster.unitconverter

import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textfield.TextInputEditText
import java.text.DecimalFormat

class TemperatureFragment : Fragment() {

    var tempList: Array<out String>? = null
    var userInputTemp:TextInputEditText? = null
    var userSelectionTemp:TextInputEditText? = null
    var arrayAdapter: ArrayAdapter<String>? = null
    var spinner:AutoCompleteTextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tempList = resources.getStringArray(R.array.temperature)
        arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, tempList!!)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_temperature, container, false)
    }

    override fun onResume() {
        super.onResume()
        tempList = resources.getStringArray(R.array.temperature)
        arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, tempList!!)
        spinner?.setAdapter(arrayAdapter)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        spinner = view?.findViewById(R.id.temperatureSelection)
        spinner?.setAdapter(arrayAdapter)
        userInputTemp = view?.findViewById(R.id.temperatureInput)!! //user temperature number

        var selectedItem:String? = null
        var calculateButton:Button? = view.findViewById(R.id.temperatureButton)

        var tempCels:TextView? = view.findViewById(R.id.temperature_cels_result)
        var tempFahr:TextView? = view.findViewById(R.id.temperature_fahr_result)
        var tempKelv:TextView? = view.findViewById(R.id.temperature_kelv_result)

        spinner?.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            selectedItem = parent.getItemAtPosition(position) as String

        })


            var format = DecimalFormat("0.0#")
            var list = mutableListOf<TextView?>(tempCels, tempFahr, tempKelv)


        fun setText(): Boolean {
            Log.i("SPINNER TEXT", selectedItem.toString())
            when{

                selectedItem.toString().equals("null") -> {
                    return false
                }

                selectedItem!!.equals("Celsius") -> {
                    tempCels?.text = userInputTemp?.text.toString()
                    tempFahr?.text = (userInputTemp?.text.toString().toDouble() * 9/5 + 32).toString()
                    tempKelv?.text = (userInputTemp?.text.toString().toDouble() + 273.15).toString()

                }

                selectedItem!!.equals("Fahrenheit") -> {
                    tempCels?.text = ((userInputTemp?.text.toString().toDouble() - 32) * 5 / 9).toString()
                    tempFahr?.text = userInputTemp?.text.toString()
                    tempKelv?.text = (((userInputTemp?.text.toString().toDouble() - 32) * 5 / 9 ) + 273.15).toString()
                }

                selectedItem!!.equals("Kelvin") -> {
                    tempCels?.text = (userInputTemp?.text.toString().toDouble() - 273.15).toString()
                    tempFahr?.text =( ((userInputTemp?.text.toString().toDouble() - 273.15) * 9 / 5) + 32).toString()
                    tempKelv?.text = userInputTemp?.text.toString()
                }


            }

            for(item in list){
                item?.text = format.format(item?.text.toString().toDouble()).toString()

            }

            return true
        }

        calculateButton?.setOnClickListener(){

            if(userInputTemp!!.text.isNullOrEmpty()){
                Snackbar.make(requireView()!!, "Please enter temperature!", Snackbar.LENGTH_SHORT).show()
            }
            else if (setText())
            {
                Snackbar.make(requireView()!!, "Your temperature has been calculated!", Snackbar.LENGTH_SHORT).show()
            }else
            {
                Snackbar.make(requireView()!!, "Please select temperature unit!", Snackbar.LENGTH_SHORT).show()
            }


        }

    }
}