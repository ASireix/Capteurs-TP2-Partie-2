package com.example.countryapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class CountryDetailFragment : Fragment(R.layout.fragment_country_detail) {

    private lateinit var countryDetailName: TextView
    private lateinit var countryDetailCapital: TextView
    private lateinit var countryDetailPopulation: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryDetailName = view.findViewById(R.id.countryDetailName)
        countryDetailCapital = view.findViewById(R.id.countryDetailCapital)
        countryDetailPopulation = view.findViewById(R.id.countryDetailPopulation)

        val country = arguments?.getParcelable<Country>("country")
        country?.let {
            countryDetailName.text = it.name
            countryDetailCapital.text = "Capital: ${it.capital}"
            countryDetailPopulation.text = "Population: ${it.population}"
        }
    }

    companion object {
        fun newInstance(country: Country): CountryDetailFragment {
            val fragment = CountryDetailFragment()
            val args = Bundle()
            args.putParcelable("country", country)
            fragment.arguments = args
            return fragment
        }
    }
}
