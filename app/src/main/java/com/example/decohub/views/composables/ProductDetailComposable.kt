package com.example.decohub.views.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.decohub.R

@Composable
fun ProductDetailComposable(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            Row(
                Modifier
                    .padding(horizontal = 25.dp)
                    .padding(bottom = 25.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.marker),
                        contentDescription = null,
                        tint = Color(0xFF242424),
                        modifier = Modifier
                            .size(25.dp)
                            .clickable { }
                    )
                }

                Button(
                    onClick = {
                        navController.navigate("cart")
                    },
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .height(60.dp)
                        .width(325.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424)),
                ) {
                    Text(
                        text = "Add to cart",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                        color = Color.White
                    )
                }
            }
        }
    ) { i ->
        Column(
            Modifier
                .fillMaxSize()
                .background(Color(0xFFf6f7fd))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.floor_lamp),
                    contentDescription = null,
                    modifier = Modifier
                        .height(450.dp)
                        .fillMaxSize()
                        .padding(start = 50.dp)
                        .shadow(1.dp, RoundedCornerShape(bottomStart = 50.dp))
                        .clip(shape = RoundedCornerShape(bottomStart = 50.dp)),
                    contentScale = ContentScale.FillBounds,
                )
                Column(
                    Modifier
                        .align(Alignment.CenterStart)
                        .padding(top = 20.dp)
                        .padding(start = 20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        Modifier
                            .height(50.dp)
                            .width(50.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .clickable {
                                navController.popBackStack()
                            },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.left_arrow),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(50.dp))
                    Column(
                        Modifier
                            .clip(shape = RoundedCornerShape(40.dp))
                            .background(Color.White)
                    ) {
                        Column(
                            Modifier
                                .height(200.dp)
                                .width(65.dp)
                                .padding(vertical = 20.dp),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                Modifier
                                    .size(35.dp)
                                    .background(Color(0xFF909090), CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    Modifier
                                        .size(25.dp)
                                        .background(Color(0xFFFFFFFF), CircleShape)
                                )
                            }

                            Box(
                                Modifier
                                    .size(35.dp)
                                    .background(Color(0xFF909090), CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    Modifier
                                        .size(25.dp)
                                        .background(Color.Blue, CircleShape)
                                )
                            }

                            Box(
                                Modifier
                                    .size(35.dp)
                                    .background(Color(0xFF909090), CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    Modifier
                                        .size(25.dp)
                                        .background(Color.Green, CircleShape)
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 30.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Minimal Stand",
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.gelasio_medium))
                )

                Row(
                    Modifier
                        .padding(vertical = 20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$ 50",
                        fontSize = 30.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                        fontWeight = FontWeight.Bold
                    )
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
                            Icon(
                                painter = painterResource(id = R.drawable.plus),
                                contentDescription = null,
                                tint = Color(0xFF242424),
                                modifier = Modifier
                                    .size(18.dp)
                                    .clickable { }
                            )
                        }

                        Text(
                            text = "01",
                            modifier = Modifier.padding(horizontal = 20.dp),
                            fontSize = 22.sp,
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
                            Icon(
                                painter = painterResource(id = R.drawable.minus),
                                contentDescription = null,
                                tint = Color(0xFF242424),
                                modifier = Modifier
                                    .size(18.dp)
                                    .clickable { }
                            )
                        }

                    }
                }

                Row(
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color(0xFFF2C94C)),
                        modifier = Modifier.size(25.dp)
                    )

                    Text(
                        text = "4.5",
                        modifier = Modifier.padding(horizontal = 20.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                    )

                    Text(
                        text = "(50 reviews)",
                        modifier = Modifier.padding(horizontal = 20.dp),
                        fontSize = 18.sp,
                        color = Color(0xFF808080),
                        fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                    )

                }

                Text(
                    text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
                    modifier = Modifier.padding(vertical = 20.dp),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Justify,
                    color = Color(0xFF808080),
                    fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                )
            }
        }
    }
}