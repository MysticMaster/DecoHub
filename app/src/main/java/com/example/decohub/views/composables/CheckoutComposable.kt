package com.example.decohub.views.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
fun CheckoutComposable(navController: NavController) {
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
                    text = "Check out",
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

                Column(
                    Modifier
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(Color.White),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Column(
                        modifier = Modifier.padding(15.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(vertical = 15.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Order:",
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                                color = Color(0xFF808080)
                            )
                            Text(
                                text = "$ 95.00",
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF303030)
                            )
                        }

                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(vertical = 15.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Delivery:",
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                                color = Color(0xFF808080)
                            )
                            Text(
                                text = "$ 5.00",
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF303030)
                            )
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
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                                color = Color(0xFF808080)
                            )
                            Text(
                                text = "$ 100.00",
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF303030)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(25.dp))

                Button(
                    onClick = {
                         navController.navigate("success")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424)),
                ) {
                    Text(
                        text = "SUBMIT ORDER",
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
                .padding(top = 50.dp)
                .background(Color(0xFFf6f7fd))
                .verticalScroll(rememberScrollState())
        ) {

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 15.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Shipping Address",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                    color = Color(0xFF808080)
                )

                Image(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    colorFilter = ColorFilter.tint(Color.Black)
                )
            }

            Column(
                Modifier
                    .padding(horizontal = 20.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(Color.White)
            ) {
                Text(
                    modifier = Modifier.padding(20.dp),
                    text = "Bruno Fernandes",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                    color = Color(0xFF303030)
                )
                Spacer(
                    Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFC0C0C0))
                )
                Text(
                    modifier = Modifier.padding(20.dp),
                    text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                    color = Color(0xFF808080)
                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Payment",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                    color = Color(0xFF808080)
                )

                Image(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    colorFilter = ColorFilter.tint(Color(0xFF808080))
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.card),
                    contentDescription = null,
                    modifier = Modifier
                        .height(70.dp)
                        .width(95.dp),
                    contentScale = ContentScale.FillWidth
                )

                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = "**** **** **** 3947",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                    color = Color(0xFF242424)
                )

            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Delivery method",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                    color = Color(0xFF808080)
                )

                Image(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    colorFilter = ColorFilter.tint(Color(0xFF808080))
                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dhl),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(20.dp)
                        .width(120.dp)
                        .height(25.dp),
                    contentScale = ContentScale.Crop
                )

                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Fast (2-3days)",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                    color = Color(0xFF242424)
                )

            }

        }
    }
}