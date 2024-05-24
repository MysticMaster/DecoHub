package com.example.decohub.views.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.decohub.R

@Composable
fun SuccessComposable(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SUCCESS!",
            fontSize = 36.sp,
            letterSpacing = 3.sp,
            fontFamily = FontFamily(Font(R.font.merriweather_bold))
        )

        Box {
            Box(
                modifier = Modifier
                    .padding(25.dp)
                    .height(280.dp)
                    .width(320.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.oxo),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillWidth,
                )

                Image(
                    painter = painterResource(id = R.drawable.all),
                    contentDescription = null,
                    modifier = Modifier
                        .size(230.dp)
                        .align(Alignment.Center),
                    contentScale = ContentScale.FillWidth,
                )
            }

            Image(
                painter = painterResource(id = R.drawable.check),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp)
                    .align(Alignment.BottomCenter),
                contentScale = ContentScale.FillBounds,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Your order will be delivered soon. \nThank you for choosing our app!",
            fontSize = 19.sp,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
            color = Color(0xFF606060)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {
                // navController.navigate("succes")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .height(60.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424)),
        ) {
            androidx.compose.material3.Text(
                text = "Track your orders",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                 navController.navigate("home")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .height(60.dp),
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White),
        ) {
            androidx.compose.material3.Text(
                text = "BACK TO HOME",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                color = Color(0xFF242424)
            )
        }

    }
}