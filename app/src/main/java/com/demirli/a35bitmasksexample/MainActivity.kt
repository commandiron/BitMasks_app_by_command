package com.demirli.a35bitmasksexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.experimental.and
import kotlin.experimental.xor

class MainActivity : AppCompatActivity() {

    private lateinit var gmtList: List<CityGmt>
    private lateinit var mAdapter: CityAdapter
    private lateinit var gmtBinaryList: ArrayList<Byte>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gmtList = listOf(
                CityGmt("Moscow",3, 0),
                CityGmt("Paris" ,2,0),
                CityGmt("Berlin" ,2,0),
                CityGmt("Brussels" ,2,0),
                CityGmt("Amsterdam" ,2,0),
                CityGmt("Rome" ,2,0),
                CityGmt("London" ,1,0),
                CityGmt("Dublin" ,1,0),
                CityGmt("New York" ,-4,0),
                CityGmt("Washington, DC" ,-4,0),
                CityGmt("St. Louis" ,-5,0),
                CityGmt("Los Angeles" ,-7,0),
                CityGmt("Tokyo" ,9,0),
                CityGmt("Beijing" ,8,0),
                CityGmt("Ho Chi Mihn City" ,7,0),
                CityGmt("Mumbai" ,5,0)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = CityAdapter(gmtList)
        recyclerView.adapter = mAdapter

        createBinaryList()

        findCities_btn.setOnClickListener {

            clearCheckBoxes()

            if(setGmt.text.toString() != ""){
                var selectionGmtBinary = setGmt.text.toString().toInt().toByte()

                bitwiseOperationForList(selectionGmtBinary, gmtBinaryList)
            }

            mAdapter.notifyDataSetChanged()
        }
    }

    fun createBinaryList() {
        gmtBinaryList = arrayListOf<Byte>()
        for (i in gmtList){
            val a= i.gmt.toByte()
            gmtBinaryList.add(a)
        }
    }

    fun clearCheckBoxes(){
        for (i in gmtList){
            i.isSelected = 0
        }
    }

    fun bitwiseOperationForList(selectionGmt: Byte, gmtBinaryList: ArrayList<Byte>){

        var count = 0
        for(i in gmtBinaryList){

            var result = selectionGmt xor i

            if(result.toString() == "0"){
                gmtList[count].isSelected = 1
            }
            count++
        }
    }
}
