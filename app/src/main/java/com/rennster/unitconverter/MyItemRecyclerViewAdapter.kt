package com.rennster.unitconverter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.rennster.unitconverter.placeholder.PlaceholderContent.PlaceholderItem
import com.rennster.unitconverter.databinding.FragmentOtherBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentOtherBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentOtherBinding) : RecyclerView.ViewHolder(binding.root) {
        val button: Button = binding.button2

        override fun toString(): String {
            return button.setText("$position").toString()
        }
    }

}