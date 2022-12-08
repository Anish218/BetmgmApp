package com.example.assignmentone.presentation

import android.annotation.SuppressLint
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.unit.sp
import com.example.assignmentone.presentation.navigation.NavItem


@SuppressLint("SuspiciousIndentation")
@Composable
fun AppBottomNavigation(kFunction1: (Int) -> Unit) {
    val context= LocalView.current

    val navItems = listOf(NavItem.Sports, NavItem.Casino, NavItem.Promotions, NavItem.Account)

    BottomNavigation(
        backgroundColor = Color.Black,
    ) {
        // val navBackStackEntry by navController.currentBackStackEntryAsState()
        //val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = stringResource(item.title))},
                label = { Text(text = stringResource(item.title), fontSize = 9.sp) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected =true,
                onClick = {
                    var id=1
                    if(item==NavItem.Sports)
                        id=com.example.assignmentone.R.id.sportsFragment
                    if(item==NavItem.Casino)
                        id=com.example.assignmentone.R.id.casinoFragment
                    if(item==NavItem.Promotions)
                        id=com.example.assignmentone.R.id.promotionFragment
                    if(item==NavItem.Account)
                        id=com.example.assignmentone.R.id.accountFragment
                    kFunction1(id)
                    //context.findNavController().navigate(id)

                    //                    navController.navigate(item.navRoute) {
//                        navController.graph.startDestinationRoute?.let { screen_route ->
//                            popUpTo(screen_route) {
//                                saveState = true
//                            }
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    }

                }
            )
        }
    }
}