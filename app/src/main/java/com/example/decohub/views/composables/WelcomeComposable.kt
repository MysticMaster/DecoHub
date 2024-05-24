package com.example.decohub.views.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.decohub.R

@Composable
fun WelcomeComposable(navController: NavController){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = "MAKE YOUR",
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 231.dp)
                .padding(start = 30.dp),
            fontFamily = FontFamily(Font(R.font.gelasio_medium)),
            color = Color(0xFF606060)
        )

        Text(
            text = "HOME BEAUTIFUL",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 276.dp)
                .padding(start = 30.dp),
            fontFamily = FontFamily(Font(R.font.gelasio_bold)),
            color = Color(0xFF303030)
        )

        Text(
            text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 349.dp)
                .padding(start = 49.dp, end = 22.dp),
            textAlign = TextAlign.Justify,
            lineHeight = 35.sp,
            fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
            color = Color(0xFF808080)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 608.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    navController.navigate("login")
                },
                modifier = Modifier
                    .height(60.dp)
                    .width(185.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424)),
            ) {
                Text(
                    text = "Get Started",
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.gelasio_medium)),
                    color = Color.White
                )
            }
        }

    }
}