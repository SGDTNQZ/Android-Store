package com.projects.androidsneakerstore.catalog.models

import androidx.annotation.DrawableRes

data class Product(
    val brandName : String,
    val description : String,
    val price : Int,
    @DrawableRes
    val image : Int
)
