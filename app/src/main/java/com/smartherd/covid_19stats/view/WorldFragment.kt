package com.smartherd.covid_19stats.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NavUtils.navigateUpTo
import androidx.fragment.app.Fragment
import com.smartherd.covid_19stats.R
import com.smartherd.covid_19stats.extension.showToast
import com.smartherd.covid_19stats.model.World
import com.smartherd.covid_19stats.webservice.ServiceBuilder
import com.smartherd.covid_19stats.webservice.WebWorldInterface
import kotlinx.android.synthetic.main.fragment_world.*
import org.eazegraph.lib.models.PieModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.NumberFormat
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class WorldFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_world, container, false)
        makeCall()
        return view
    }

    fun makeCall() {
        val worldInterface: WebWorldInterface =
            ServiceBuilder.buildService(WebWorldInterface::class.java)
        val requestCall: Call<World> = worldInterface.getWorldData()

        requestCall.enqueue(object : Callback<World> {
            override fun onFailure(call: Call<World>, t: Throwable) {
                context!!.showToast("Error Occurs")
            }

            override fun onResponse(call: Call<World>, response: Response<World>) {

                if (response.isSuccessful) {

                    val world = response.body()

                    world?.let {
                       // detail_toolbar.subtitle= it.updated?.let { it1 -> getDate(it1) }

                        w_totalCases.text =
                            NumberFormat.getNumberInstance(Locale.getDefault())
                                .format(world.cases)
                        w_totalActiveCases.text =
                            NumberFormat.getNumberInstance(Locale.getDefault())
                                .format(world.active)
                        w_totalRecoveredCases.text =
                            NumberFormat.getNumberInstance(Locale.getDefault())
                                .format(world.recovered)
                        w_totalDeaths.text =
                            NumberFormat.getNumberInstance(Locale.getDefault())
                                .format(world.deaths)
                        w_totalCritical.text =
                            NumberFormat.getNumberInstance(Locale.getDefault())
                                .format(world.critical)
                        w_totalTodayCases.text = NumberFormat.getNumberInstance(Locale.getDefault())
                            .format(world.todayCases)

                        /* ========  Pie Chart =========*/
                        activity_main_piechart.addPieSlice(
                            PieModel(
                                "Active",
                                Integer.parseInt(it.cases.toString()).toFloat(),
                                Color.parseColor("#007afe")
                            )
                        )
                        activity_main_piechart.addPieSlice(
                            PieModel(
                                "Recovered",
                                Integer.parseInt(it.recovered.toString()).toFloat(),
                                Color.parseColor("#7EC544")
                            )
                        )
                        activity_main_piechart.addPieSlice(
                            PieModel(
                                "Deaths",
                                Integer.parseInt(it.deaths.toString()).toFloat(),
                                Color.parseColor("#F6404F")
                            )
                        )
                    }
                }
            }
        })
    }
    private fun getDate(time: Long): String? {
        val cal = Calendar.getInstance(Locale.ENGLISH)
        cal.timeInMillis = time * 1000
        return DateFormat.format("dd-MM-yyyy", cal).toString()
    }

}
