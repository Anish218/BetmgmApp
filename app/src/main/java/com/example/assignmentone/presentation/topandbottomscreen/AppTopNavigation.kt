package com.example.assignmentone.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.assignmentone.R
import com.example.assignmentone.common.sharedpreferences.Store

import com.example.assignmentone.presentation.loginscreen.LoginFragment
import com.example.assignmentone.presentation.sportsscreen.SportsScreenFragment

//import com.example.assignmentone.presentation.ComposeView.UserCard

@Composable
fun AppTopNavigation(navigate: (Int) -> Unit) {
    val view= LocalView.current
    val context= LocalContext.current
    val scope= rememberCoroutineScope()
    val dataStore= Store(context)
    val sportsScreenFragment = SportsScreenFragment()
    var bottomBarStatus = dataStore.getBottomBarStatus.collectAsState(initial = false)

    val loginScreenFragment = LoginFragment()
    Column(

        Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .padding(start = 10.dp)
    ) {
        Row() {
            Column() {

                Row() {


                Text(
                    color = colorResource(id = com.example.assignmentone.R.color.gold),
                    text = "BET",
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp
                )
                Text(
                    color = colorResource(id = com.example.assignmentone.R.color.gold),
                    text = "MGM",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )}
                Text(
                    color = colorResource(id = com.example.assignmentone.R.color.white),
                    text = "NEW JERSEY",
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )

            }
            Button(

                modifier = Modifier
                    .padding(start = 115.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.White
                ),
                border = BorderStroke(1.5.dp, Color.DarkGray),
                shape = RoundedCornerShape(55.dp),


                onClick = {
                    if(bottomBarStatus.value==true){
                    navigate(R.id.loginFragment)}

                }
            ) {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.width(5.dp))

            Button(

                modifier = Modifier
                    .padding(start = 5.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = com.example.assignmentone.R.color.gold),
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(55.dp),

                onClick = {
                    if(bottomBarStatus.value==true){

                    navigate(R.id.registerFragment)}

                }
            ) {
                Text(text = "Register")
            }


        }
        Spacer(modifier = Modifier.height(5.dp))


    }
}


@Preview(showBackground = true)
@Composable
fun AppTopNavigationPreview() {
    //AppBottomNavigation()
}