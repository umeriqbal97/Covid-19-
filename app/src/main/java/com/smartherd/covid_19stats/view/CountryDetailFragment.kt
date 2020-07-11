package com.smartherd.covid_19stats.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.smartherd.covid_19stats.R
import com.smartherd.covid_19stats.model.Country
import kotlinx.android.synthetic.main.fragment_country_detail.*
import java.text.NumberFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class CountryDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val country=arguments?.getParcelable<Country>("detail")
        val rank= arguments?.getInt("rank")
        showData(country,rank)

    }

    private fun showData(countries: Country?, position: Int?) {

        countries?.let {
            d_cases.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.cases)
            d_active.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.active)
            d_today_deaths.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.todayDeaths)
            d_today_cases.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.todayCases)
            d_critical.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.critical)
            d_total_tests.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.tests)
            d_recovered.text =
                NumberFormat.getNumberInstance(Locale.getDefault()).format(countries.recovered)

            d_country.text = countries.country
            d_rank.text = (position).toString()

        }

    }

}
