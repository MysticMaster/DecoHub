package com.example.decohub.views.fragment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.decohub.R

class Filter(val id: Int, val image: Int, val title: String)
class Product(val id: Int, val image: Int, val name: String, val price: Float)

@Composable
fun HomeFragment(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        painterResource(id = R.drawable.search),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = Color(0xFF808080)
                    )

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Make home",
                            fontSize = 23.sp,
                            fontFamily = FontFamily(Font(R.font.gelasio_medium)),
                            color = Color(0xFF909090)
                        )
                        Text(
                            text = "BEAUTIFUL",
                            fontSize = 23.sp,
                            fontFamily = FontFamily(Font(R.font.gelasio_bold)),
                            color = Color(0xFF242424)
                        )
                    }

                    Icon(
                        painterResource(id = R.drawable.cart),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                navController.navigate("cart")
                            },
                        tint = Color(0xFF808080)
                    )

                }
            }
        ) { innerPadding ->
            var selectedItem by remember { mutableStateOf<Int?>(0) }
            val filters = listOf(
                Filter(0, R.drawable.star, "Popular"),
                Filter(1, R.drawable.chair, "Chair"),
                Filter(2, R.drawable.table, "Table"),
                Filter(3, R.drawable.sofa, "Armchair"),
                Filter(4, R.drawable.bed, "Bed"),
            )

            val products = listOf(
                Product(0, R.drawable.floor_lamp, "Black Simple Lamp", 12.00f),
                Product(1, R.drawable.shefe, "Minimal Stand", 25.00f),
                Product(2, R.drawable.lounge, "Coffee Chair", 20.00f),
                Product(3, R.drawable.dressing_table, "Simple Desk", 50.00f),
                Product(4, R.drawable.dressing_table, "Simple Desk", 50.00f)
            )

            Column(Modifier.padding(innerPadding)) {
                LazyRow(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, start = 24.dp),
                ) {
                    items(filters) { item ->
                        Column(
                            Modifier
                                .padding(end = 30.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column(
                                Modifier
                                    .height(60.dp)
                                    .width(60.dp)
                                    .clip(shape = RoundedCornerShape(12.dp))
                                    .background(
                                        if (item.id == selectedItem) Color(0xFF303030) else Color(
                                            0xFFf5f5f5
                                        )
                                    )
                                    .clickable { selectedItem = item.id },
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painterResource(id = item.image),
                                    contentDescription = null,
                                    modifier = Modifier.size(30.dp),
                                    tint = if (item.id == selectedItem) Color(0xFFFFFFFF) else Color(
                                        0xFF909090
                                    )
                                )
                            }

                            Text(
                                modifier = Modifier.padding(top = 10.dp),
                                text = item.title,
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                                color = if (item.id == selectedItem) Color(0xFF242424) else Color(
                                    0xFF999999
                                )
                            )
                        }
                    }
                }

                LazyVerticalGrid(
                    GridCells.Fixed(2),  // Thiết lập 2 cột
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(bottom = 50.dp)
                ) {
                    items(products) { item ->
                        Column(Modifier.padding(10.dp)) {
                            Box {
                                Image(
                                    painter = painterResource(id = item.image),
                                    contentDescription = null,
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .height(260.dp)
                                        .clip(RoundedCornerShape(15.dp))
                                        .clickable {
                                            navController.navigate("product")
                                        }
                                    // Tạo góc bo
                                )

                                Column(
                                    Modifier
                                        .align(Alignment.BottomEnd)
                                        .height(70.dp)
                                        .width(70.dp)
                                        .padding(15.dp)
                                        .clip(shape = RoundedCornerShape(6.dp))
                                        .background(Color(0xFFC6C6C6)),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        painterResource(id = R.drawable.shopping_bag_icon),
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp),
                                        tint = Color.White
                                    )
                                }

                            }

                            Text(
                                modifier = Modifier.padding(top = 10.dp),
                                text = item.name,
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                                color = Color(0xFF606060)
                            )

                            Text(
                                text = "$ ${item.price}",
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                                color = Color(0xFF303030)
                            )

                        }
                    }
                }
            }
        }
    }
}