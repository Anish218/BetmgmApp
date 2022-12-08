package com.example.assignmentone.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.assignmentone.R
//import com.example.assignmentone.presentation.ComposeView.UserCard

@Composable
fun AppTopNavigation() {
    Column(

        Modifier
            .background(Color.Black)
            .fillMaxWidth()
    ) {
        Row() {
            Text(
                color = colorResource(id = com.example.assignmentone.R.color.dark_gold),
                text = "BET",
                fontSize = 20.sp
            )
            Text(
                color = colorResource(id = com.example.assignmentone.R.color.gold),
                text = "MGM",
                fontSize = 20.sp
            )
            Button(

                modifier = Modifier
                    .padding(start = 125.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.White
                ),
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(55.dp),


                onClick = { /*TODO*/ }
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

                onClick = { /*TODO*/ }
            ) {
                Text(text = "Register")
            }


        }
        Spacer(modifier = Modifier.height(5.dp))


    }
}

@Composable
fun GamesCard() {
    Card(
        modifier = Modifier

            .padding(7.dp)
            .fillMaxWidth()
            .wrapContentSize()
            .height(30.dp),
        elevation = 4.dp,
        backgroundColor = Color.Black,
        border = BorderStroke(1.dp,Color.White),
        shape = RoundedCornerShape(20.dp)


    ) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription ="",
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
                .padding(start = 5.dp)
        )
        Text(
            modifier = Modifier.padding(start = 20.dp),
            color = Color.White,
            text = "something"
        )
    }

}

@Preview(showBackground = true)
@Composable
fun AppTopNavigationPreview() {
    //AppBottomNavigation()
}