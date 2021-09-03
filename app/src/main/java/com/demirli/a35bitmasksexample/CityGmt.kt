package com.demirli.a35bitmasksexample

data class CityGmt(
    var name: String,
    var gmt: Int,
    var isSelected: Int

){
    fun getGmtBinary(): Int{
        var gmtBinaryNumber = 0
        if(gmt > 0){
            gmtBinaryNumber = 1 shl gmt-1
        }else if(gmt < 0){
            gmtBinaryNumber = 1 shl gmt*-1+11
        }
        return gmtBinaryNumber
    }
}