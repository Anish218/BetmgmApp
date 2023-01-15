package com.example.assignmentone.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignmentone.MainActivity
import com.example.assignmentone.common.sharedpreferences.Store
import com.example.assignmentone.presentation.navigation.NAV_SPORTS
import com.example.assignmentone.presentation.navigation.NavItem
import com.example.assignmentone.presentation.sportsscreen.SportsScreenViewModel
import com.example.assignmentone.presentation.viewModel.MainViewModel
import kotlinx.coroutines.launch


@SuppressLint("SuspiciousIndentation")
@Composable
fun AppBottomNavigation(
    mainViewModel: MainViewModel,
    sportsScreenViewModel: SportsScreenViewModel,
    kFunction1: (Int) -> Unit
) {
    val context= LocalContext.current
    val scope= rememberCoroutineScope()
    val dataStore=Store(context)
    var bottomBarStatus = dataStore.getBottomBarStatus.collectAsState(initial = false)
    var bottomBarIconColor = dataStore.getIconColorStatus.collectAsState(initial = NAV_SPORTS)

    println("current bottom bar status"+bottomBarStatus.value)



    val navItems = listOf(NavItem.Sports, NavItem.Casino, NavItem.Promotions, NavItem.Account)

    BottomNavigation(
        modifier=Modifier.height(60.dp),
        backgroundColor = Color.Black,
    ) {
        // val navBackStackEntry by navController.currentBackStackEntryAsState()
//        val navBackStackEntry = LocalView.current.findNavController().currentBackStackEntry!!.destination.id
//        println("****"+navBackStackEntry)

//        val currentroute= navBackStackEntry!!.destination!!.route

        navItems.forEach { item ->
                println("inside true")

                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = stringResource(item.title)
                        )
                    },
                    label = {
                        if (bottomBarIconColor.value == item.navRoute) Text(
                            text = stringResource(item.title),
                            color = Color.White, fontSize = 9.sp
                        )
                        if (bottomBarIconColor.value != item.navRoute) Text(
                            text = stringResource(item.title),
                            color = Color.Gray, fontSize = 9.sp
                        )
                    },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = bottomBarIconColor.value == item.navRoute,
                    onClick = {
                        if (bottomBarStatus.value == true) {

                            var id = 1
                            if (item == NavItem.Sports) {

                                id = item.navRoute
                                scope.launch {
                                    println("cliked oon sports icon")

                                    dataStore.saveIconColorStatus( item.navRoute)

                                }
                                mainViewModel.changescreen(item.navRoute)
                            }
                            if (item == NavItem.Casino) {
                                id = item.navRoute
                                scope.launch {
                                    println("cliked oon casino icon")
                                    dataStore.saveIconColorStatus( item.navRoute)

                                }
                                mainViewModel.changescreen(item.navRoute)
                            }
                            if (item == NavItem.Promotions) {
                                id = item.navRoute
                                scope.launch {
                                    println("cliked oon promo icon")

                                    dataStore.saveIconColorStatus( item.navRoute)

                                }
                                mainViewModel.changescreen(item.navRoute)
                            }
                            if (item == NavItem.Account) {
                                id = item.navRoute
                                scope.launch {
                                    dataStore.saveIconColorStatus( item.navRoute)

                                }
                                mainViewModel.changescreen(item.navRoute)

                            }
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
                    }

                )


        }
    }
}