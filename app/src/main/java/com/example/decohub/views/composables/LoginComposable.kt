package com.example.decohub.views.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.decohub.R

@Composable
fun LoginComposable(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp)
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 20.dp)
            ) {
                Divider(color = Color(0xFFBDBDBD), thickness = 2.dp)
            }
            Image(
                painter = painterResource(id = R.drawable.decohub_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp)
            ) {
                Divider(color = Color(0xFFBDBDBD), thickness = 2.dp)
            }
        }

        Text(
            text = "Hello !",
            fontSize = 32.sp,
            modifier = Modifier
                .padding(top = 30.dp, start = 30.dp),
            fontFamily = FontFamily(Font(R.font.merriweather_light)),
            color = Color(0xFF909090)
        )

        Text(
            text = "WELCOME BACK",
            fontSize = 32.sp,
            modifier = Modifier
                .padding(top = 15.dp, start = 30.dp),
            fontFamily = FontFamily(Font(R.font.merriweather_bold)),
            color = Color(0xFF303030)
        )

        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(top = 30.dp, end = 30.dp)
                .shadow(2.dp)
        ) {
            var userName by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp)
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Column {
                    Text(
                        text = "Email",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                        color = Color(0xFF909090)
                    )
                    TextField(
                        value = userName,
                        onValueChange = { userName = it },
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            cursorColor = Color.Black,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                    Divider(color = Color(0xFFE0E0E0), thickness = 2.dp)
                }
                Spacer(modifier = Modifier.height(40.dp))
                Column {
                    Text(
                        text = "Password",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                        color = Color(0xFF909090)
                    )

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        trailingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.eye),
                                contentDescription = null,
                                modifier = Modifier.size(25.dp)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            cursorColor = Color.Black,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                    Divider(color = Color(0xFFE0E0E0), thickness = 2.dp)
                }

            }

            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = "Forgot Password",
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                    color = Color(0xFF303030)
                )
                Spacer(modifier = Modifier.height(40.dp))
                Button(
                    onClick = {
                        navController.navigate("home")
                    },
                    modifier = Modifier
                        .height(55.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424)),
                ) {
                    Text(
                        text = "Log in",
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.gelasio_medium)),
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "SIGN UP",
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_sans_7pt_medium)),
                    color = Color(0xFF303030),
                    modifier = Modifier.clickable {
                        navController.navigate("signup")
                    }
                )
                Spacer(modifier = Modifier.height(60.dp))
            }

        }
    }
}