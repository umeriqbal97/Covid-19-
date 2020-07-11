package com.smartherd.covid_19stats.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smartherd.covid_19stats.R
import com.smartherd.covid_19stats.model.Country
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import java.text.NumberFormat
import java.util.*

class CountriesAdapter(val context: Context, val list: List<Country>) : RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {
    inner class CountriesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun setData(country:Country,position: Int){
            itemView.country_name.text=country.country
            itemView.country_rank.text=(position+1).toString()
            Glide.with(context).load(country.countryInfo?.flag).into(itemView.country_flag)
            itemView.num_of_cases.text=NumberFormat.getNumberInstance(Locale.getDefault()).format(country.cases)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return CountriesViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val country=list[position]
        holder.setData(country,position)
    }

}