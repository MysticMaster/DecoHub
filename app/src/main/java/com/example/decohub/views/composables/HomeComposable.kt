package com.example.decohub.views.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.decohub.R
import com.example.decohub.views.fragment.AccountFrament
import com.example.decohub.views.fragment.BookmarkFrament
import com.example.decohub.views.fragment.HomeFragment
import com.example.decohub.views.fragment.NotiFragment

@Composable
fun HomeComposable(navController1: NavController) {
    val items = listOf(
        Fragment.HomeFragment,
        Fragment.BookmarkFrament,
        Fragment.NotiFragment,
        Fragment.UserFrament
    )
    var selectedItem by remember { mutableStateOf(items[0]) }
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                navController = navController,
                selectedItem = selectedItem,
                items = items,
                onItemSelected = { selectedItem = it })
        }
    ) { innerPadding ->
        Column {
            NavHost(
                navController = navController,
                startDestination = Fragment.HomeFragment.route
            ) {
                composable(Fragment.HomeFragment.route) {
                    HomeFragment(navController1)
                }
                composable(Fragment.BookmarkFrament.route) {
                    BookmarkFrament()
                }
                composable(Fragment.NotiFragment.route) {
                    NotiFragment()
                }
                composable(Fragment.UserFrament.route) {
                   AccountFrament()
                }
            }
        }
    }
}

@Composable
fun BottomNavigation(
    navController: NavController,
    selectedItem: Fragment,
    items: List<Fragment>,
    onItemSelected: (Fragment) -> Unit
) {
   BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color(0xFF909090),
        modifier = Modifier.height(75.dp)
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                },
                selectedContentColor = if (item == selectedItem) Color(0xFF242424) else Color(
                    0xFF909090
                ),
                selected = item == selectedItem,
                onClick = {
                    onItemSelected(item)
                    navController.navigate(item.route)
                }
            )
        }
    }
}

sealed class Fragment(val route: String, val icon: Int) {
    object HomeFragment : Fragment("HomeFragment", R.drawable.clarity_home_solid)
    object BookmarkFrament : Fragment("BookmarkFrament", R.drawable.marker)
    object NotiFragment : Fragment("NotiFragment", R.drawable.bell)
    object UserFrament : Fragment("UserFrament", R.drawable.bi_person)
}