package com.projects.androidsneakerstore.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projects.androidsneakerstore.R
import com.projects.androidsneakerstore.catalog.models.Product

@Composable
fun ProductCard(product: Product){
    val isAdded = remember { mutableStateOf(false)}
    Card (
        modifier = Modifier
            .width(IntrinsicSize.Min),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ){
        Image(
            painter = painterResource(product.image),
            contentDescription = "Product image",
            modifier = Modifier
                .fillMaxWidth()
                .height(166.dp)
        )

        Column (
            modifier = Modifier
                .padding(horizontal = 4.dp),
        ) {
            Text(
                text = product.brandName,
                fontSize = 13.sp,
                fontWeight = FontWeight(600),
                lineHeight = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = product.description,
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                lineHeight = 16.sp,
                color = Color(0xFF8E8E93),
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "$ ${product.price}",
                fontSize = 12.sp,
                fontWeight = FontWeight(600),
                lineHeight = 16.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {isAdded.value = !isAdded.value},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(isAdded.value) Color.Gray else Color.Black,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray
                )

            ) {
                Text(
                    text = if(isAdded.value) "Remove from cart" else "Add to cart"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview(){
    ProductCard(
        product = Product("name","desc",1000,R.drawable.img_dg)
    )
}