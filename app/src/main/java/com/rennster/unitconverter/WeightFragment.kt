package com.rennster.unitconverter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.text.DecimalFormat


class WeightFragment : Fragment() {

    var weight: Array<out String>? = null
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

        weight = resources.getStringArray(R.array.weight_measures)
        arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, weight!!)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weight, container, false)
    }

    override fun onResume() {
        super.onResume()
        weight = resources.getStringArray(R.array.weight_measures)
        arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, weight!!)
        getView()?.findViewById<AutoCompleteTextView>(R.id.weightAutoCompleteTextView)?.setAdapter(arrayAdapter)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var inputWeightUser = getView()?.findViewById<TextInputEditText>(R.id.weightInput)
        var buttonWeightCalculate: Button? = getView()?.findViewById(R.id.weightCalculateButton)
        getView()?.findViewById<AutoCompleteTextView>(R.id.weightAutoCompleteTextView)?.setAdapter(arrayAdapter)

        spinner = getView()?.findViewById<AutoCompleteTextView>(R.id.weightAutoCompleteTextView)


        var textKilogram: TextView? = getView()?.findViewById(R.id.weight_kilogram_result)
        var textGram:TextView? = getView()?.findViewById(R.id.weight_gram_result)
        var textMiligram:TextView? = getView()?.findViewById(R.id.weight_miligram_result)
        var textPound:TextView? = getView()?.findViewById(R.id.weight_pound_result)


        spinner?.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
            selectedItem = parent.getItemAtPosition(position) as String
        })

        fun setText(selectedItem:String):Boolean {

            var format = DecimalFormat("0.0000#")

            var list = mutableListOf<TextView?>(
                textKilogram,textGram, textMiligram, textPound
            )


            when{
                selectedItem.equals("Kilogram") -> {
                    textKilogram?.text = inputWeightUser?.text.toString()
                    textGram?.text = (inputWeightUser?.text.toString().toDouble() * 1000).toString()
                    textMiligram?.text = (inputWeightUser?.text.toString().toDouble() * 1000000).toString()
                    textPound?.text = (inputWeightUser?.text.toString().toDouble() * 2.2046244202).toString()

                }

                selectedItem.equals("Gram") -> {
                    textKilogram?.text = ((inputWeightUser?.text.toString().toDouble() * 0.001).toString())
                    textGram?.text = inputWeightUser?.text.toString()
                    textMiligram?.text = (inputWeightUser?.text.toString().toDouble() * 1000).toString()
                    textPound?.text = (inputWeightUser?.text.toString().toDouble() * 0.0022046244).toString()
                    Log.i("GRAM", textKilogram?.text.toString())

                }

                selectedItem.equals("Miligram") -> {
                    textKilogram?.text = ((inputWeightUser?.text.toString().toDouble() * 0.000001).toString())
                    textGram?.text = (inputWeightUser?.text.toString().toDouble() * 0.001).toString()
                    textMiligram?.text = inputWeightUser?.text.toString()
                    textPound?.text = (inputWeightUser?.text.toString().toDouble() * 0.0000022046).toString()


                }

                selectedItem.equals("Pound") -> {
                    textKilogram?.text = ((inputWeightUser?.text.toString().toDouble() * 0.453592).toString())
                    textGram?.text = (inputWeightUser?.text.toString().toDouble() * 453.592).toString()
                    textMiligram?.text = (inputWeightUser?.text.toString().toDouble() * 453592).toString()
                    textPound?.text = inputWeightUser?.text.toString()


                }


                else -> return false
            }


            for(item in list){
                item?.text = format.format(item?.text.toString().toDouble()).toString()

            }



            return true

        }

        buttonWeightCalculate?.setOnClickListener(){
            var inputDouble:Double? = null

            if(inputWeightUser?.text.isNullOrEmpty()){
                var view:View? = activity?.findViewById(android.R.id.content)
                Snackbar.make(view!!, "Please enter weight.", Snackbar.LENGTH_SHORT).show()
            }else{
                if(setText(selectedItem.toString())){
                    Snackbar.make(requireView(), "Your weight has been calculated.", Snackbar.LENGTH_SHORT).show()
                }else{
                    Snackbar.make(requireView(), "Please select lenght measure!", Snackbar.LENGTH_SHORT).show()
                }
            }
        }



    }

}