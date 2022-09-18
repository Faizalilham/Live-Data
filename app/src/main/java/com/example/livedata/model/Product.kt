package com.example.livedata.model

import java.io.Serializable

data class Product(
    val name :String,
    val image : MutableList<ListImages>,
    val price : Int,
    val stok : Int,
    val deskirpsi :String
):Serializable

data class ListImages(
    val images :Int
): Serializable