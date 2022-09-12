package com.rennster.unitconverter

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import java.text.DecimalFormat


/**
 * A simple [Fragment] subclass.
 * Use the [LenghtFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LenghtFragment : Fragment() {

    var lenght: Array<out String>? = null
    var arrayAdapter: ArrayAdapter<String>? = null
    var spinner:AutoCompleteTextView? = null
    var selectedItem:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        lenght = resources.getStringArray(R.array.lenght_first)
        arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, lenght!!)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lenght, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onResume() {
        super.onResume()
        lenght = resources.getStringArray(R.array.lenght_first)
        arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, lenght!!)
        getView()?.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)?.setAdapter(arrayAdapter)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        getView()?.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)?.setAdapter(arrayAdapter)

        spinner = getView()?.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)


        var textKilo: TextView? = getView()?.findViewById(R.id.lenght_kilo_result)
        var textMeter:TextView? = getView()?.findViewById(R.id.lenght_meter_result)
        var textDeci:TextView? = getView()?.findViewById(R.id.lenght_decimeter_result)
        var textCenti:TextView? = getView()?.findViewById(R.id.lenght_centimeter_result)
        var textMili:TextView? = getView()?.findViewById(R.id.lenght_milimeter_result)
        var textMile:TextView? = getView()?.findViewById(R.id.lenght_mile_result)




        spinner?.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
            selectedItem = parent.getItemAtPosition(position) as String
            Log.i("SPINNER TEXT", selectedItem.toString())
        })

        var inputLenghtUser = getView()?.findViewById<TextInputEditText>(R.id.lenghtInput)
        var calculateButton = getView()?.findViewById<Button>(R.id.button)


        fun setText(selectedItem:String):Boolean {

            var format = DecimalFormat("0.0#") //2 decimal digits


            var list = mutableListOf<TextView?>(
                textKilo,textMeter, textDeci, textCenti, textMili,textMile
            )


                when{
                    selectedItem.equals("Kilometer") -> {
                        textKilo?.text = inputLenghtUser?.text.toString()
                        textMeter?.text = (inputLenghtUser?.text.toString().toDouble() * 1000).toString()
                        textDeci?.text = (inputLenghtUser?.text.toString().toDouble() * 10000).toString()
                        textCenti?.text = (inputLenghtUser?.text.toString().toDouble() * 100000).toString()
                        textMili?.text = (inputLenghtUser?.text.toString().toDouble() * 1000000).toString()
                        textMile?.text =(inputLenghtUser?.text.toString().toDouble() * 0.6213688756).toString()

                    }

                    selectedItem.equals("Meter") -> {
                        textKilo?.text = ((inputLenghtUser?.text.toString().toDouble() * 0.001).toString())
                        textMeter?.text = inputLenghtUser?.text.toString()
                        textDeci?.text = (inputLenghtUser?.text.toString().toDouble() * 10).toString()
                        textCenti?.text = (inputLenghtUser?.text.toString().toDouble() * 100).toString()
                        textMili?.text = (inputLenghtUser?.text.toString().toDouble() * 1000).toString()
                        textMile?.text = (inputLenghtUser?.text.toString().toDouble() * 0.0006213689).toString()

                    }

                    selectedItem.equals("Decimeter") -> {
                        textKilo?.text = ((inputLenghtUser?.text.toString().toDouble() * 0.0001).toString())
                        textMeter?.text = (inputLenghtUser?.text.toString().toDouble() * 0.1).toString()
                        textDeci?.text = inputLenghtUser?.text.toString()
                        textCenti?.text = (inputLenghtUser?.text.toString().toDouble() * 10).toString()
                        textMili?.text = (inputLenghtUser?.text.toString().toDouble() * 100).toString()
                        textMili?.text = (inputLenghtUser?.text.toString().toDouble() * 0.0000621371).toString()
                        textMile?.text = (inputLenghtUser?.text.toString().toDouble() * 0.00006213689).toString()
                    }

                    selectedItem.equals("Centimeter") -> {
                        textKilo?.text = ((inputLenghtUser?.text.toString().toDouble() * 0.00001).toString())
                        textMeter?.text = (inputLenghtUser?.text.toString().toDouble() * 0.01).toString()
                        textDeci?.text = (inputLenghtUser?.text.toString().toDouble() * 0.1).toString()
                        textCenti?.text = inputLenghtUser?.text.toString()
                        textMili?.text = (inputLenghtUser?.text.toString().toDouble() * 10).toString()
                        textMile?.text = (inputLenghtUser?.text.toString().toDouble() * 0.000006213689).toString()

                    }

                    selectedItem.equals("Milimeter") -> {
                        textKilo?.text = ((inputLenghtUser?.text.toString().toDouble() * 0.000001).toString())
                        textMeter?.text = (inputLenghtUser?.text.toString().toDouble() * 0.001).toString()
                        textDeci?.text = (inputLenghtUser?.text.toString().toDouble() * 0.01).toString()
                        textCenti?.text = (inputLenghtUser?.text.toString().toDouble() * 0.1).toString()
                        textMili?.text = inputLenghtUser?.text.toString()
                        textMile?.text = (inputLenghtUser?.text.toString().toDouble() * 0.0000006213689).toString()

                    }

                    selectedItem.equals("Mile") -> {
                        textKilo?.text = (inputLenghtUser?.text.toString().toDouble() * 1.60935).toString()
                        textMeter?.text = (inputLenghtUser?.text.toString().toDouble() * 1609.35).toString()
                        textDeci?.text = (inputLenghtUser?.text.toString().toDouble() * 16093.4).toString()
                        textCenti?.text = (inputLenghtUser?.text.toString().toDouble() * 160935).toString()
                        textMili?.text = (inputLenghtUser?.text.toString().toDouble() * 1609350).toString()
                        textMile?.text = inputLenghtUser?.text.toString()
                    }

                    else -> return false
                }
                for(item in list){

                        item?.text = format.format(item?.text.toString().toDouble()).toString()


                }



            return true

        }

            calculateButton?.setOnClickListener(){
                var inputDouble:Double? = null
                    if(inputLenghtUser?.text.isNullOrEmpty()){
                        var view: View? = activity?.findViewById(android.R.id.content)
                        Snackbar.make(view!!, "Please enter lenght.", Snackbar.LENGTH_SHORT).show()
                    }else{
                            Log.i("SPINNER TEXT", spinner?.text.toString())
                            if(setText(selectedItem.toString())){
                                Snackbar.make(requireView(), "Your lenght has been calculated!", Snackbar.LENGTH_SHORT).show()
                            }else{
                                Snackbar.make(requireView(), "Please select lenght measure!", Snackbar.LENGTH_SHORT).show()
                            }

                    }
            }



    }



}