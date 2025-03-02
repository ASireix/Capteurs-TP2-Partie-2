package com.example.countryapp

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CountryListFragment : Fragment(R.layout.fragment_country_list) {

    private lateinit var countryRecyclerView: RecyclerView
    private val countries = listOf(
        Country("France", "Paris", 67391582),
        Country("Germany", "Berlin", 83166711),
        Country("Spain", "Madrid", 46719142)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryRecyclerView = view.findViewById(R.id.countryRecyclerView)
        countryRecyclerView.layoutManager = LinearLayoutManager(context)
        countryRecyclerView.adapter = CountryAdapter(countries) { country ->
            (activity as MainActivity).showCountryDetails(country)
        }

        countryRecyclerView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.recyclerViewBackground))
    }
}

