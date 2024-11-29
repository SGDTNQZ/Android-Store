package com.projects.androidsneakerstore.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projects.androidsneakerstore.R
import com.projects.androidsneakerstore.catalog.models.Product

@Composable
fun CatalogScreen(){
    val listOfProducts = listOf(
        Product("Nike","Nike Air Max",100, R.drawable.img_jordanpng),
        Product("Adidas","Adidas Ultra Boost",150, R.drawable.img_sneaker),
        Product("Puma","Puma Suede",90, R.drawable.img_dg),
        Product("Reebok","Reebok Classic",120, R.drawable.img_offwhite),
        Product("New Balance","New Balance 574",110, R.drawable.img_sneaker),
        Product("Converse","Converse Chuck Taylor",80, R.drawable.img_jordanpng),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
            .safeDrawingPadding()
            .background(color = Color(0xFFF6F6F6)),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            Header()
        }
        items(listOfProducts.size) { index ->
            ProductCard(product = listOfProducts[index])
        }
    }
}


@Composable
fun Header(){
    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = "Hello, Sneakerhead!",
            fontSize = 17.sp,
            fontWeight = FontWeight(600),
            lineHeight = 22.sp
        )
    }
}