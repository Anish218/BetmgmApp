package com.example.assignmentone.presentation.sportsscreen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignmentone.R
import com.example.assignmentone.presentation.GamesCard
import com.example.assignmentone.presentation.navigation.NavItem


data class User(
    val id:Int
)
val users = listOf(
    User(1),
    User(1),User(1),User(1),User(1),User(1),User(1),User(1),User(1),User(1),
)



@Composable
fun SportsScreenView() {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Card(
                modifier = Modifier.height(30.dp),
                backgroundColor = colorResource(id = R.color.dark_gray),
                shape = RoundedCornerShape(20.dp)
            ) {
                Image(
                    modifier = Modifier.padding(start = 3.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_dehaze_24 ),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .padding(start = 28.dp, top = 5.dp)
                        .width(50.dp),
                    color = Color.White,
                    text = "sports"
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Card(
                modifier = Modifier.height(30.dp),
                backgroundColor = colorResource(id = R.color.dark_gray),
                shape = RoundedCornerShape(20.dp)
            ) {
                Image(

                    painter = painterResource(id = R.drawable.ic_baseline_search_24 ),
                    contentDescription = ""
                )
                Text(modifier = Modifier
                    .padding(start = 25.dp)
                    .width(270.dp),
                    color = Color.White,
                    text = "search")
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        LazyRow{
            items(users){ user ->
                GamesCard()


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
                        items(users) { user ->
                            GameEventCard()


                        }
                    }
                }

            }


            // Turning the list in a list of lists of two elements each
            items(users.windowed(1, 1, true)) { sublist ->
                Row(Modifier.fillMaxWidth()) {
                    sublist.forEach { item ->
                        GameDetailsCard()
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
                        items(users) { user ->
                            GameEventCard()


                        }
                    }
                }

            }


        }
    }






//    LazyColumn(
//
//        modifier = Modifier
//            .background(Color.Black)
//            .padding(top = 150.dp),
//    ) {
//        item {
//            Column(modifier = Modifier.fillMaxWidth()) {
//                LazyRow {
//                    items(users) { user ->
//                        GameEventCard()
//
//
//                    }
//                }
//            }
//
//        }
//
//
//        // Turning the list in a list of lists of two elements each
//        items(users.windowed(1, 1, true)) { sublist ->
//            Row(Modifier.fillMaxWidth()) {
//                sublist.forEach { item ->
//                    GameDetailsCard()
//                }
//            }
//        }
//        item {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 60.dp)
//                    .wrapContentSize()
//            ) {
//                LazyRow {
//                    items(users) { user ->
//                        GameEventCard()
//
//
//                    }
//                }
//            }
//
//        }
//
//
//    }
}


@Composable
fun GameDetailsCard(){
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)

        ){
            Text(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth(),
                text = "NFL"
            )




        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .padding(start = 200.dp, top = 35.dp)
                .fillMaxWidth()
        ) {
            Card(

                modifier = Modifier
                    .height(34.dp)
                    .width(150.dp)
                    .padding(start = 10.dp),
                backgroundColor = colorResource(id = R.color.dark_gray),
                shape = RoundedCornerShape(20.dp)
            ) {

                Text(modifier = Modifier
                    .padding(start = 15.dp, top = 5.dp),
                    color = Color.White,
                    text = "hornets " + "by" + "1" + "5")
                Spacer(modifier = Modifier.width(15.dp))
                Image(

                    painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24 ),
                    contentDescription = "",
                    modifier = Modifier.padding(start = 100.dp)

                )

            }
        }
        Spacer(modifier = Modifier.height(0.dp))
        Row(
            modifier = Modifier.padding(top = 70.dp)
        ) {
            Text(
                modifier = Modifier.padding(start = 30.dp),
                text = "Hawks")
            Image(
                painterResource(id = R.drawable.ic_launcher_background), contentDescription ="",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(20.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))

            Text(text = "@")
            Spacer(modifier = Modifier.width(15.dp))
            Image(
                painterResource(id = R.drawable.ic_launcher_background), contentDescription ="",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(20.dp)
            )
            Text(text = "Knicks")

        }
        Row(
            modifier = Modifier
                .padding(top = 100.dp)
                .background(color = Color.Gray)
        ) {
            Spacer(modifier = Modifier
                .background(color = Color.Blue)
                .fillMaxWidth())
            Text(modifier = Modifier.padding(start = 30.dp),
                text = ".........")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "winning Margin")
            Spacer(modifier = Modifier.width(10.dp))
            Text(modifier = Modifier.padding(start = 30.dp),
                text = ".........")


        }

        Row(
            modifier = Modifier.padding(top = 130.dp, bottom = 10.dp)
        ) {
            Card(

                modifier = Modifier
                    .height(34.dp)
                    .width(150.dp)
                    .padding(start = 10.dp),
                backgroundColor = colorResource(id = R.color.dark_gray),
                shape = RoundedCornerShape(20.dp)
            ) {

                Text(modifier = Modifier
                    .padding(start = 15.dp, top = 5.dp),
                    color = Color.White,
                    text = "hornets " + "by" + "1" + "5")
                Spacer(modifier = Modifier.width(15.dp))
                Image(

                    painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24 ),
                    contentDescription = "",
                    modifier = Modifier.padding(start = 100.dp)

                )

            }
            Spacer(modifier = Modifier.width(5.dp))
            Card(
                modifier = Modifier
                    .height(34.dp)
                    .width(80.dp)
                    .padding(start = 5.dp),
                backgroundColor = colorResource(id = R.color.dark_gray),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(

                    modifier = Modifier.padding(5.dp),
                    text = "8.00",
                    color = Color.White)
            }
        }







    }
}


@Composable
fun GameEventCard() {
    Card(

        elevation = 4.dp,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)

        ){
            Text(text = "Tommorrow")
            Spacer(modifier = Modifier.width(1.dp))
            Image(
                painterResource(id = R.drawable.ic_baseline_circle_24 )  , contentDescription = "",
                modifier = Modifier
                    .size(15.dp)
                    .padding(start = 5.dp, top = 5.dp)

            )

            Text(text = "10:30 AM")
            Spacer(modifier = Modifier.width(40.dp))
            Text(text = "NBA")


        }
        Spacer(modifier = Modifier.height(0.dp))
        Row(
            modifier = Modifier.padding(top = 70.dp)
        ) {
            Text(
                modifier = Modifier.padding(start = 30.dp),
                text = "Hawks")
            Image(
                painterResource(id = R.drawable.ic_launcher_background), contentDescription ="",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(20.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))

            Text(text = "@")
            Spacer(modifier = Modifier.width(15.dp))
            Image(
                painterResource(id = R.drawable.ic_launcher_background), contentDescription ="",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(20.dp)
            )
            Text(text = "Knicks")

        }
        Row(
            modifier = Modifier
                .padding(top = 100.dp)
                .background(color = Color.Gray)
        ) {
            Spacer(modifier = Modifier
                .background(color = Color.Blue)
                .fillMaxWidth())
            Text(modifier = Modifier.padding(start = 30.dp),
                text = ".........")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "winning Margin")
            Spacer(modifier = Modifier.width(10.dp))
            Text(modifier = Modifier.padding(start = 30.dp),
                text = ".........")


        }

        Row(
            modifier = Modifier.padding(top = 130.dp, bottom = 10.dp)
        ) {
            Card(

                modifier = Modifier
                    .height(34.dp)
                    .width(150.dp)
                    .padding(start = 10.dp),
                backgroundColor = colorResource(id = R.color.dark_gray),
                shape = RoundedCornerShape(20.dp)
            ) {

                Text(modifier = Modifier
                    .padding(start = 15.dp, top = 5.dp),
                    color = Color.White,
                    text = "hornets " + "by" + "1" + "5")
                Spacer(modifier = Modifier.width(15.dp))
                Image(

                    painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24 ),
                    contentDescription = "",
                    modifier = Modifier.padding(start = 100.dp)

                )

            }
            Spacer(modifier = Modifier.width(5.dp))
            Card(
                modifier = Modifier
                    .height(34.dp)
                    .width(80.dp)
                    .padding(start = 5.dp),
                backgroundColor = colorResource(id = R.color.dark_gray),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(

                    modifier = Modifier.padding(5.dp),
                    text = "8.00",
                    color = Color.White)
            }
        }







    }

}














//    Column(){
//        LazyRow(){
//            items(users){user->
//                GameEventCard()
//            }
//        }
//        LazyColumn(){
//            items(users){user->
//                GameDetailsCard()
//
//            }
//        }
//
//    }

//    LazyColumn(){
//        items(users){user1->
//            GameDetailsCard()
//            LazyRow{
//                items(users){user2->
//                    GameEventCard()
//
//                }
//            }
//
//        }
//    }

//    Box(
//        Modifier
//            .background(Color.Black)
//            .fillMaxSize()
//    )
//
//    {
//        LazyRow {
//            items(users) { user ->
//                GameEventCard()
//
//
//            }
//        }
//        LazyColumn(
//            modifier = Modifier.padding(top=180.dp)
//        ){
//
//            items(users){user ->
//                GameDetailsCard()
//            }
//        }
//    }