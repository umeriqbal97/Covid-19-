package com.smartherd.covid_19stats.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.covid_19stats.adapter.CountriesAdapter

import com.smartherd.covid_19stats.R
import com.smartherd.covid_19stats.extension.showToast
import com.smartherd.covid_19stats.model.Country
import com.smartherd.covid_19stats.webservice.ServiceBuilder
import com.smartherd.covid_19stats.webservice.WebCountriesInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class CountriesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView=view.findViewById(R.id.recyclerView)

        val webCountryInterface=ServiceBuilder.buildService(WebCountriesInterface::class.java)
        val requestCall = webCountryInterface.getCountriesList()

        requestCall.enqueue(object : Callback<List<Country>>{
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                context?.showToast("Error")
            }

            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if(response.isSuccessful){
                    val country=response.body()

                    try {
                        val layoutManager = LinearLayoutManager(requireContext())
                        layoutManager.orientation = LinearLayoutManager.VERTICAL
                        recyclerView.layoutManager = layoutManager

                        // sorting the list
                        val sortedList =
                            country?.sortedWith(compareByDescending({ it.cases }))

                        recyclerView.adapter = sortedList?.let {
                            CountriesAdapter(
                                requireContext(),
                                sortedList
                            )
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }



                }
            }

        })

    }

}
