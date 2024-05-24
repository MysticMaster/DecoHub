package com.example.decohub.views.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.decohub.ui.theme.DecoHubTheme
import com.example.decohub.views.composables.CartComposable
import com.example.decohub.views.composables.CheckoutComposable
import com.example.decohub.views.composables.HomeComposable
import com.example.decohub.views.composables.LoginComposable
import com.example.decohub.views.composables.ProductDetailComposable
import com.example.decohub.views.composables.SignupComposable
import com.example.decohub.views.composables.SuccessComposable
import com.example.decohub.views.composables.WelcomeComposable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DecoHubTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 50.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Welcome.route
                    ) {
                        composable(Screen.Welcome.route) {
                            WelcomeComposable(navController = navController)
                        }
                        composable(Screen.Login.route) {
                            LoginComposable(navController = navController)
                        }
                        composable(Screen.SignUp.route) {
                            SignupComposable(navController = navController)
                        }
                        composable(Screen.Home.route) {
                            HomeComposable(navController)
                        }
                        composable(Screen.ProductDetail.route) {
                            ProductDetailComposable(navController = navController)
                        }
                        composable(Screen.Cart.route) {
                            CartComposable(navController)
                        }
                        composable(Screen.Checkout.route) {
                            CheckoutComposable(navController)
                        }
                        composable(Screen.Success.route) {
                            SuccessComposable(navController)
                        }
                    }
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object SignUp : Screen("signup")
    object Home : Screen("home")
    object ProductDetail : Screen("product")
    object Cart : Screen("cart")
    object Checkout : Screen("checkout")
    object Success : Screen("success")
}
