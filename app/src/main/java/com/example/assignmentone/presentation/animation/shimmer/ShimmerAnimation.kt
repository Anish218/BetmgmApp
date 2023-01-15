package com.example.assignmentone.presentation.animation.shimmer

import android.app.Activity
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.assignmentone.presentation.sportsscreen.*

@Composable
fun ShimmerAnimation(sportsScreenViewModel: SportsScreenViewModel,exitapp:()->Unit) {
    val isLobbyApiSuccess by sportsScreenViewModel.showDailog.observeAsState()
    val showDialog= remember{ mutableStateOf(false) }
    showDialog.value=isLobbyApiSuccess!!
    println("!!!!!"+showDialog.value+isLobbyApiSuccess)
    Card() {
        if (showDialog.value!!) {
            AlertDialog(
                title = {
                    Text("Attention!!")
                },
                text = {
                    Text(text = "Lobby Api Failed to succeed")
                },
                onDismissRequest = {showDialog.value=false},
                confirmButton = {
                TextButton(onClick = {
                    println("cliekd")
                    showDialog.value=false
                    exitapp()
                }

                ) {
                    Text("OK")
                }
                },
                dismissButton = {}
            )
        }
    }
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f) ,
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f)

    )

    val transition = rememberInfiniteTransition()
    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )
        )
    )
    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnimation.value,y=translateAnimation.value)
    )
    ShimmerItems(brush)
//    ShimmerItem(brush)
}


@Composable
fun ShimmerItem(brush: Brush){
    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(250.dp)
                .background(brush)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .padding(vertical = 8.dp)
                .background(brush = brush)
        )
    }
}
@Composable
fun ShimmerItems(brush: Brush){
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {

        Spacer(modifier = Modifier.height(40.dp))
        LazyRow{
            items(5){ user ->
                GamesCardShimmer(brush)


            }
        }


    }

    Column(
        modifier = Modifier.padding(top = 90.dp)
    ) {

        LazyColumn(

            modifier = Modifier
                .background(Color.Black)
                .padding(top = 10.dp),
        ) {
            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    LazyRow {
                        items(2) { user ->
                            GameEventCardShimmer(brush)


                        }
                    }
                }

            }


            // Turning the list in a list of lists of two elements each
            items(GamesItems.windowed(1, 1, true)) { sublist ->
                Row(Modifier.fillMaxWidth()) {
                    sublist.forEach { item ->
                        GameDetailsCardShimmer(brush)
                    }
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 60.dp)
                        .wrapContentSize()
                ) {
                    LazyRow {
                        items(GamesItems) { user ->
                            GameEventCardShimmer(brush)


                        }
                    }
                }

            }


        }
    }

}

@Composable
fun GamesCardShimmer(brush: Brush){
    Card(
        elevation = 4.dp,
        backgroundColor = Color.Black,
        border = BorderStroke(1.dp,Color.DarkGray),
        modifier = Modifier
            .padding(7.dp)
            .fillMaxWidth()
            .width(80.dp)
            .height(30.dp),
        shape = RoundedCornerShape(20.dp)

    ) {
        Row() {
            Spacer(modifier = Modifier
                .size(30.dp)
                .padding(5.dp)
                .background(brush, shape = CircleShape)
            )
            Spacer(modifier = Modifier
                .padding(start = 0.5.dp))
            Spacer(modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .size(40.dp)
                .background(brush, shape = RoundedCornerShape(10.dp))
            )

        }

    }

}
@Composable
fun GameEventCardShimmer(brush:Brush){
    Card(
        elevation = 4.dp,
        backgroundColor = Color.Black,
        border = BorderStroke(1.dp,Color.DarkGray),
        modifier = Modifier
            .padding(5.dp)
            .width(260.dp)

            .height(200.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        // date
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 5.dp)
        ) {
            Spacer(modifier = Modifier
                .background(brush, shape = RoundedCornerShape(10.dp))
                .width(180.dp)
                .size(15.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Spacer(modifier = Modifier

                .background(brush, shape = RoundedCornerShape(10.dp))
                .width(60.dp)
                .size(15.dp))
        }
        //participants name
        Row(
            modifier = Modifier.padding(top = 80.dp)
        ) {
            Spacer(modifier = Modifier
                .padding(start = 30.dp, top = 2.dp)
                .background(brush, shape = RoundedCornerShape(10.dp))
                .width(60.dp)
                .size(15.dp))
            Spacer(modifier = Modifier.width(3.dp))
            Spacer(modifier = Modifier
                .size(18.dp)
                .background(brush, shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Spacer(modifier = Modifier
                .size(18.dp)
                .background(brush, shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Spacer(modifier = Modifier
                .size(18.dp)
                .background(brush, shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(2.dp))
            Spacer(modifier = Modifier
                .background(brush, shape = RoundedCornerShape(10.dp))
                .padding(top = 2.dp)
                .width(60.dp)
                .size(15.dp))


        }
        Row(
            modifier = Modifier.padding(top = 120.dp)
        ) {
            Spacer(modifier = Modifier
                .background(brush, shape = RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .size(15.dp))
        }
        Row(
            modifier = Modifier.padding(top = 150.dp)
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Spacer(modifier = Modifier
                .background(brush, shape = RoundedCornerShape(10.dp))
                .padding(start = 30.dp)
                .width(80.dp)
                .size(30.dp))
            Spacer(modifier = Modifier.width(60.dp))
            Spacer(modifier = Modifier
                .background(brush, shape = RoundedCornerShape(10.dp))
                .width(60.dp)
                .size(30.dp))

        }
//        Spacer(modifier = Modifier
//            .size(200.dp)
//            .background(brush))

    }



}
@Composable
fun GameDetailsCardShimmer(brush: Brush){
    Card(
        elevation = 4.dp,
        backgroundColor = Color.Black,
        border = BorderStroke(1.dp,Color.DarkGray),
        modifier = Modifier
            .padding(top = 10.dp)
            .wrapContentSize()
            .wrapContentHeight()
        ,
        shape = RoundedCornerShape(8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 5.dp)
        ) {
            Spacer(modifier = Modifier
                .background(brush, shape = RoundedCornerShape(10.dp))
                .width(380.dp)
                .size(35.dp))

        }
        Spacer(modifier = Modifier.height(10.dp))
        //Game lines
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
        ) {
            Spacer(modifier = Modifier
                .padding(start = 260.dp)
                .background(brush, shape = RoundedCornerShape(10.dp))
                .width(100.dp)
                .size(25.dp))

        }
        //spread total money

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 85.dp)
        ) {
            Spacer(modifier = Modifier
                .padding(start = 190.dp)
                .background(brush, shape = RoundedCornerShape(10.dp))
                .width(45.dp)
                .size(15.dp))
            Spacer(modifier = Modifier.width(14.dp))
            Spacer(modifier = Modifier
                .background(brush, shape = RoundedCornerShape(10.dp))
                .width(45.dp)
                .size(15.dp))
            Spacer(modifier = Modifier.width(14.dp))
            Spacer(modifier = Modifier
                .background(brush, shape = RoundedCornerShape(10.dp))
                .width(45.dp)
                .size(15.dp))


        }
        // for bets
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 130.dp)
        ) {
            Column(
                modifier = Modifier.padding(start = 10.dp,top=14.dp)
            ) {
                Spacer(modifier = Modifier
                    .size(18.dp)
                    .background(brush, shape = CircleShape)
                )
                Spacer(modifier = Modifier.height(40.dp))
                Spacer(modifier = Modifier
                    .size(18.dp)
                    .background(brush, shape = CircleShape)
                )

            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(

            ) {
                Spacer(modifier = Modifier
                    .padding(top = 19.dp)
                    .background(brush, shape = RoundedCornerShape(10.dp))
                    .width(90.dp)
                    .size(10.dp))
                Spacer(modifier = Modifier.height(47.dp))

                Spacer(modifier = Modifier
                    .background(brush, shape = RoundedCornerShape(10.dp))
                    .width(90.dp)
                    .size(10.dp))
            }
            Spacer(modifier = Modifier.width(60.dp))
            Column(

            ) {
                Spacer(modifier = Modifier
                    .background(brush, shape = RoundedCornerShape(10.dp))
                    .size(50.dp))
                Spacer(modifier = Modifier.height(5.dp))
                Spacer(modifier = Modifier
                    .background(brush, shape = RoundedCornerShape(10.dp))
                    .size(50.dp))
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(

            ) {
                Spacer(modifier = Modifier
                    .background(brush, shape = RoundedCornerShape(10.dp))
                    .size(50.dp))
                Spacer(modifier = Modifier.height(5.dp))
                Spacer(modifier = Modifier
                    .background(brush, shape = RoundedCornerShape(10.dp))
                    .size(50.dp))
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(

            ) {
                Spacer(modifier = Modifier
                    .background(brush, shape = RoundedCornerShape(10.dp))
                    .size(50.dp))
                Spacer(modifier = Modifier.height(5.dp))
                Spacer(modifier = Modifier
                    .background(brush, shape = RoundedCornerShape(10.dp))
                    .size(50.dp))
            }


        }
        Spacer(modifier = Modifier.height(30.dp))
        // date after bets
        Row(
            modifier =Modifier.padding(top = 250.dp)
        ) {
            Spacer(modifier = Modifier
                .padding(start = 5.dp)
                .background(brush, shape = RoundedCornerShape(10.dp))
                .width(100.dp)
                .size(15.dp))
            Spacer(modifier = Modifier.width(15.dp))
            Spacer(modifier = Modifier
                .background(brush, shape = RoundedCornerShape(10.dp))
                .width(100.dp)
                .size(15.dp))
            Spacer(modifier = Modifier.width(60.dp))
            Spacer(modifier = Modifier
                .background(brush, shape = RoundedCornerShape(10.dp))
                .width(100.dp)
                .size(15.dp))
        }
        Spacer(modifier = Modifier.height(5.dp))
        //all events part
        Row(
            modifier = Modifier.padding(top = 280.dp, bottom = 5.dp)
        ) {
            Spacer(modifier = Modifier
                .padding(start = 5.dp)
                .background(brush, shape = RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .size(25.dp))

        }




//        Spacer(modifier = Modifier
//            .background(brush)
//            .size(200.dp))

    }
}
@Composable
fun Alert(name: String,
          showDialog: Boolean,
          onDismiss: () -> Unit) {
    val activity = (LocalContext.current as? Activity)

    val localcontext = LocalContext.current
    if (showDialog) {

    }
}