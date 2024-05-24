package com.example.decohub.views.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.decohub.R
import com.example.decohub.views.fragment.Product

@Composable
fun CartComposable(navController: NavController) {

    val products = listOf(
        Product(0, R.drawable.floor_lamp, "Black Simple Lamp", 12.00f),
        Product(1, R.drawable.shefe, "Minimal Stand", 25.00f),
        Product(2, R.drawable.lounge, "Coffee Chair", 20.00f),
        Product(3, R.drawable.dressing_table, "Simple Desk", 50.00f),
        Product(4, R.drawable.dressing_table, "Simple Desk", 50.00f)
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painterResource(id = R.drawable.left_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            navController.popBackStack()
                        },
                    tint = Color.Black
                )

                Text(
                    text = "My cart",
                    fontSize = 23.sp,
                    fontFamily = FontFamily(Font(R.font.gelasio_medium)),
                    color = Color(0xFF242424)
                )


                Text(text = "")

            }
        },
        bottomBar = {
            Column(
                Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Row(
                    Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextField(
                        value = "",
                        onValueChange = {},
                        textStyle = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium))),
                        label = {
                            Text(
                                text = "Enter your promo code",
                                fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                                color = Color(0xFF999999)
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            cursorColor = Color.Black,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )

                    Column(
                        Modifier
                            .clip(shape = RoundedCornerShape(8.dp))
                            .background(Color.Black)
                            .height(50.dp)
                            .width(50.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }
                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total:",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                        color = Color(0xFF808080)
                    )
                    Text(
                        text = "$ 95.00",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF303030)
                    )
                }

                Button(
                    onClick = {
                         navController.navigate("checkout")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424)),
                ) {
                    Text(
                        text = "Check out",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                        color = Color.White
                    )
                }
            }
        }

    ) { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .background(Color(0xFFf6f7fd))
        ) {
            LazyColumn(
                Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 40.dp, bottom = 150.dp)
            ) {
                items(products) { item ->
                    Box {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(vertical = 15.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {

                            Row {
                                Image(
                                    painter = painterResource(id = item.image),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(110.dp)
                                        .height(110.dp)
                                        .clip(shape = RoundedCornerShape(10.dp)),
                                    contentScale = ContentScale.Crop
                                )

                                Column(
                                    Modifier
                                        .fillMaxHeight()
                                        .padding(start = 20.dp)
                                        .height(110.dp),
                                    verticalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column {
                                        Text(
                                            text = item.name,
                                            fontSize = 16.sp,
                                            fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                                            color = Color(0xFF606060)
                                        )

                                        Text(
                                            text = "$ ${item.price}",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                                            color = Color(0xFF303030)
                                        )
                                    }

                                    Row(
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column(
                                            Modifier
                                                .height(40.dp)
                                                .width(40.dp)
                                                .clip(shape = RoundedCornerShape(8.dp))
                                                .background(Color.White),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            androidx.compose.material3.Icon(
                                                painter = painterResource(id = R.drawable.plus),
                                                contentDescription = null,
                                                tint = Color(0xFF242424),
                                                modifier = Modifier
                                                    .size(16.dp)
                                                    .clickable { }
                                            )
                                        }

                                        Text(
                                            text = "01",
                                            modifier = Modifier.padding(horizontal = 20.dp),
                                            fontSize = 18.sp,
                                            fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                                        )

                                        Column(
                                            Modifier
                                                .height(40.dp)
                                                .width(40.dp)
                                                .clip(shape = RoundedCornerShape(8.dp))
                                                .background(Color.White),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            androidx.compose.material3.Icon(
                                                painter = painterResource(id = R.drawable.minus),
                                                contentDescription = null,
                                                tint = Color(0xFF242424),
                                                modifier = Modifier
                                                    .size(16.dp)
                                                    .clickable { }
                                            )
                                        }
                                    }
                                }
                            }

                            Image(
                                modifier = Modifier.size(23.dp),
                                painter = painterResource(id = R.drawable.cancel),
                                contentDescription = null
                            )

                        }
                        Spacer(
                            Modifier
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter)
                                .height(1.dp)
                                .background(Color(0xFFC0C0C0))
                        )
                    }
                }
            }
        }
    }
}