package com.example.countryapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Random

class CountryAdapter(
    private val countryList: List<Country>,
    private val onItemClick: (Country) -> Unit
) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val countryName: TextView = view.findViewById(R.id.countryName)
        val itemLayout: LinearLayout = view.findViewById(R.id.itemLayout) // Ajoutez un ID au LinearLayout parent dans XML
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.countryName.text = country.name

        val random = Random()
        val color = Color.rgb(
            150 + random.nextInt(105),
            150 + random.nextInt(105),
            150 + random.nextInt(105)
        )

        holder.itemLayout.setBackgroundColor(color)
        holder.itemView.setOnClickListener { onItemClick(country) }
    }


    override fun getItemCount() = countryList.size
}
