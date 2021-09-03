package com.demirli.a35bitmasksexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CityAdapter(var gmtList: List<CityGmt>): RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.city_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = gmtList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.cityName.setOnCheckedChangeListener(null)

        holder.cityName.text = gmtList[position].name
        if(gmtList[position].isSelected == 1){
            holder.cityName.isChecked = true
        }else{
            holder.cityName.isChecked = false
        }

        holder.gmt.text = gmtList[position].gmt.toString()

        holder.cityName.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if(isChecked == true){
                    gmtList[position].isSelected = 1
                }
            }
        })


    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val cityName = view.findViewById<CheckBox>(R.id.cityname_cb)
        val gmt = view.findViewById<TextView>(R.id.gmt_tv)

    }
}