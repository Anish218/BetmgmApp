package com.example.assignmentone.presentation.sportsscreen


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignmentone.R
import com.example.assignmentone.data.dto.lobby.Fixture


data class Games(
    val id:Int,
    val name:String
)
val GamesItems = listOf(
    Games(R.drawable.casino,"casino"),
    Games(R.drawable.soccer,"Soccer"),Games(R.drawable.nhlnew,"NHL"),Games(R.drawable.nfl_logo,"NFL"),Games(R.drawable.tennis,"Tennis"),Games(R.drawable.nba_logo,"NBA"),
)

data class GameEventJersey(
    val oponent_one: Int,
    val oponent_two: Int
)
val GameEventJerseyList = listOf(
    GameEventJersey(R.drawable.jersey3,R.drawable.jersey3),GameEventJersey(R.drawable.jersey3,R.drawable.jersey3)
)

data class GameLobby(
    val oponent_one:Int,
    val oponent_two: Int
)
val GameLobbyList = listOf(
    GameLobby(R.drawable.milwauke,R.drawable.cleveland),
    GameLobby(R.drawable.detroitpistons,R.drawable.philadelphers),
    GameLobby(R.drawable.milwauke,R.drawable.cleveland),
    GameLobby(R.drawable.detroitpistons,R.drawable.philadelphers),
    GameLobby(R.drawable.milwauke,R.drawable.cleveland),
    GameLobby(R.drawable.detroitpistons,R.drawable.philadelphers),
    GameLobby(R.drawable.milwauke,R.drawable.cleveland),
    GameLobby(R.drawable.detroitpistons,R.drawable.philadelphers),

    )



@Composable
fun SportsScreenView(sportsScreenViewModel: SportsScreenViewModel,navigate: (Int) -> Unit) {
    val fixtures=sportsScreenViewModel.fixtures
    Column(
        modifier = Modifier

            .background(Color.Black)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Card(
                modifier = Modifier.height(30.dp).padding(start=8.dp),
                backgroundColor = colorResource(id = R.color.dark_gray),
                shape = RoundedCornerShape(20.dp)
            ) {
                Image(
                    modifier = Modifier.padding(start = 7.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_dehaze_24 ),
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .padding(start = 35.dp, top = 5.dp)
                        .width(50.dp),
                    color = Color.White,
                    text = "Sports"
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Card(
                modifier = Modifier.height(30.dp).clickable(onClick = { navigate(R.id.action_sportsFragment_to_searchSportFragment)}),
                backgroundColor = colorResource(id = R.color.dark_gray),
                shape = RoundedCornerShape(20.dp)
            ) {
                Image(
                    modifier = Modifier.padding(start = 6.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_search_24 ),
                    contentDescription = ""
                )
                Text(modifier = Modifier
                    .padding(start = 35.dp, top = 5.dp)
                    .width(270.dp),
                    color = Color.White,
                    text = "Search Sports")
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        LazyRow{
            items(GamesItems){ game ->
                GamesCard(game)


            }
        }
    }
    Column(
        modifier = Modifier.padding(top = 90.dp, bottom = 150.dp)
    ) {

        LazyColumn(

            modifier = Modifier
                .background(Color.Black)
                .padding(top = 10.dp),
        ) {
            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    fixtures.value?.let { println("fixtures size "+it.size) }
//                     if(fixtures.value?.size==0) {
//
//                         LazyRow {
//                             items(GamesItems) { user ->
//                                 GameEventCard()
//
//
//                             }
//                         }
//                     }
                    //                   else
//                     {
                    LazyRow {
                        println(fixtures.value?.size)
                        var count=0

                        fixtures.value?.let {
                            items(it) { fixture->
                                if(count==0)
                                {
                                    CardEventAd()
                                }
                                GameEventCard(fixture, GameEventJerseyList.get(count))
                                count++
                                if (count%2 == 0){
                                    count = 0
                                }
                            }
                        }

                    }
                }
            }

//            }

            var count=0
            // Turning the list in a list of lists of two elements each
            items(GameLobbyList.windowed(1, 1, true)) { sublist ->
                Row(Modifier.fillMaxWidth()) {
                    sublist.forEach { participant ->
                        GameDetailsCard(participant)
                    }
                }
            }



        }
    }
}
@Composable
fun CardEventAd(){
    Card(

        elevation = 4.dp,
        modifier = Modifier
            .padding(5.dp)
            .width(315.dp)

            .height(180.dp)
        ,

        shape = RoundedCornerShape(8.dp)

    ){
        Image(
            painter = painterResource(R.drawable.game_boost_bg)
            ,
            contentDescription = null,
            modifier = Modifier
                .background(color = Color.Blue)
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column {
            Text(color = colorResource(id = R.color.gold)
                ,text = "FIRST BET",
                modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp


            )
            Text(color = colorResource(id = R.color.white)
                ,text = "FREE BET MATCH\nUP TO $1,000",
                modifier = Modifier.padding( start = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp


            )
            Button(

                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .padding(start = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = com.example.assignmentone.R.color.gold),
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(55.dp),

                onClick = { /*TODO*/ }
            ) {
                Text(text = "Bet Now",
                    fontSize = 15.sp)
            }
        }

    }
}


@Composable
fun GameDetailsCard(participant: GameLobby) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
        ,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()


        ){
            Box(
                modifier = Modifier
                    .background(colorResource(id = R.color.dull_gray))
                    .fillMaxWidth()
                    .size(45.dp)
            ) {
                Text(
                    modifier = Modifier.padding(start = 15.dp, top = 12.dp),
                    fontWeight = FontWeight.Bold,
                    text = "NFL"
                )
            }





        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .padding(start = 230.dp, top = 50.dp)
                .fillMaxWidth()
        ) {
            Card(

                modifier = Modifier
                    .height(34.dp)
                    .width(150.dp)
                    .padding(start = 10.dp,),
                backgroundColor = Color.White,
                shape = RoundedCornerShape(20.dp)
            ) {

                Text(modifier = Modifier
                    .padding(start = 15.dp, top = 5.dp),
                    color = Color.Black,
                    text = "Game Lines")
                Spacer(modifier = Modifier.width(15.dp))
                Image(

                    painter = painterResource(id = R.drawable.arrow_down_blue ),
                    contentDescription = "",
                    modifier = Modifier.padding(start = 100.dp)

                )

            }
        }

        Row(
            modifier = Modifier.padding( top = 95.dp)
        ) {
            Text(
                modifier = Modifier.padding(start = 210.dp),
                text = "Spread")

            Spacer(modifier = Modifier.width(20.dp))

            Text(text = "Total")
            Spacer(modifier = Modifier.width(30.dp))

            Text(text = "Money")

        }
        Row(
            modifier = Modifier
                .padding(top = 140.dp)
                .size(110.dp)
        ) {
            Column(
                modifier = Modifier
                    .height(100.dp)
                    .width(40.dp)
                    .background(Color.White)
            ) {

                Image(

                    painter = painterResource(id = participant.oponent_one ),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 10.dp, top = 18.dp)
                        .size(25.dp)
                        .clip(shape = CircleShape)

                )
                Spacer(modifier = Modifier.height(28.dp))
                Image(

                    painter = painterResource(id = participant.oponent_two ),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(25.dp)
                        .clip(shape = CircleShape)

                )
            }
            Column() {
                Text(
                    text = "Las Vegas Raider",
                    modifier = Modifier.padding(top = 20.dp),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(35.dp))
                Text(text = "Los Angeles Rams",fontWeight = FontWeight.Bold)

            }
            Spacer(modifier = Modifier.width(50.dp))

            Column(

            ) {
                Box(

                    modifier = Modifier
                        .size(55.dp)
                        .border(
                            BorderStroke(1.5.dp, Color.LightGray),
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(9.dp)
                    ) {
                        Text( text = "+1.8",)
                        Text( text = "37.8",fontWeight = FontWeight.Bold)

                    }
                }
                Spacer(modifier = Modifier.height(3.dp))
                Box(

                    modifier = Modifier
                        .size(55.dp)
                        .border(
                            BorderStroke(1.5.dp, Color.LightGray),
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(9.dp)
                    ) {
                        Text( text = "+1.8",)
                        Text( text = "37.8",fontWeight = FontWeight.Bold)

                    }
                }
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column(

            ) {
                Box(

                    modifier = Modifier
                        .size(55.dp)
                        .border(
                            BorderStroke(1.5.dp, Color.LightGray),
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(9.dp)
                    ) {
                        Text( text = "+1.8",)
                        Text( text = "37.8",fontWeight = FontWeight.Bold)

                    }
                }
                Spacer(modifier = Modifier.height(3.dp))
                Box(

                    modifier = Modifier
                        .size(55.dp)
                        .border(
                            BorderStroke(1.5.dp, Color.LightGray),
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(9.dp)
                    ) {
                        Text( text = "+1.8",)
                        Text( text = "37.8",fontWeight = FontWeight.Bold)

                    }
                }
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column(

            ) {
                Box(

                    modifier = Modifier
                        .size(55.dp)
                        .border(
                            BorderStroke(1.5.dp, Color.LightGray),
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(9.dp)
                    ) {
                        Text( text = "+1.8",)
                        Text( text = "37.8",fontWeight = FontWeight.Bold)

                    }
                }
                Spacer(modifier = Modifier.height(3.dp))
                Box(

                    modifier = Modifier
                        .size(55.dp)
                        .border(
                            BorderStroke(1.5.dp, Color.LightGray),
                            shape = RoundedCornerShape(5.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier.padding(9.dp)
                    ) {
                        Text( text = "+1.8",)
                        Text( text = "37.8",fontWeight = FontWeight.Bold)

                    }
                }
            }




        }
        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.padding(start = 10.dp, top = 265.dp)
        ) {
            Row(
                modifier = Modifier.padding(top = 5.dp)
            ) {
                Text(text = "Tommorrow")
                Spacer(modifier = Modifier.width(1.dp))
                Image(
                    painterResource(id = R.drawable.ic_baseline_circle_24 )  , contentDescription = "",
                    modifier = Modifier
                        .size(12.dp)
                        .padding(start = 5.dp, top = 7.dp)

                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(text = "10:30 AM")
            }

            Spacer(modifier = Modifier.width(15.dp))
            Box(
                modifier = Modifier
                    .background(
                        colorResource(id = R.color.dull_gold),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(bottom = 5.dp)

            )
            {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "One Game Parlay")
            }

            Spacer(modifier = Modifier.width(10.dp))
            Box() {
                Text(modifier = Modifier.padding(top = 5.dp), text = "All Wagers", color = Color.Blue)

                Image(painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24), contentDescription ="",
                    modifier = Modifier.padding(start = 65.dp, top = 5.dp),
                )
            }

        }
        Row(modifier = Modifier.padding(top = 305.dp)) {
            Box(
                modifier = Modifier
                    .border(border = BorderStroke(1.dp, Color.LightGray))
                    .fillMaxWidth()
                    .size(45.dp)
                    .background(Color.White)
            ) {
                Text(text = "All Events", modifier = Modifier.padding(start = 10.dp,top= 10.dp))
                Spacer(modifier = Modifier.width(50.dp))
                Image(painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24), contentDescription ="",
                    modifier = Modifier.padding(start = 363.dp, top = 5.dp),
                )
            }
        }

    }


}


@Composable
fun GameEventCard(fixture: Fixture?=null,jersey: GameEventJersey) {
    val strs = fixture?.startTime?.split(" ")?.toTypedArray()
    val date= strs?.get(0)
    var time= strs?.get(1)
    var amOrPm=strs?.get(2)
    val maxChar = 8


    Card(

        elevation = 4.dp,
        modifier = Modifier
            .padding(5.dp)
            .width(315.dp)

            .height(180.dp)
        ,

        shape = RoundedCornerShape(8.dp)

    ) {
        Image(
            painter = painterResource(R.drawable.marquee_image)
            ,
            contentDescription = null,
            modifier = Modifier
                .background(color = Color.Blue)
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        Row(
            modifier = Modifier

                .fillMaxWidth()
                .padding(14.dp)

        ) {



                Text(text = date ?: "Tommorow", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(1.dp))
                Image(
                    painterResource(id = R.drawable.ic_baseline_circle_24), contentDescription = "",
                    modifier = Modifier
                        .size(12.dp)
                        .padding(start = 5.dp, top = 7.dp)

                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(text = time ?: "10:00", fontWeight = FontWeight.Bold)
                Text(text = amOrPm ?: "PM", fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.width(80.dp))
                Text(
                    modifier = Modifier.padding(start = 2.dp), text = fixture?.name ?: "NBA",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )


            }
            Spacer(modifier = Modifier.height(0.dp))
            Row(
                modifier = Modifier.padding(top = 70.dp)
            ) {

                Text(
                    modifier = Modifier
                        .padding(start = 35.dp)
                        .width(65.dp),

                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    text = fixture?.participateContentList?.get(0)?.name ?: "Hawks",
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(5.dp))
                Image(
                    painterResource(id = jersey.oponent_one), contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(20.dp)
                )
                Spacer(modifier = Modifier.width(25.dp))

                Text(text = "@")
                Spacer(modifier = Modifier.width(25.dp))
                Image(
                    painterResource(id = jersey.oponent_two), contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(20.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = fixture?.participateContentList?.get(1)?.name ?: "Knicks",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(65.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

            }
            Row(
                modifier = Modifier
                    .padding(top = 100.dp)

            ) {
                Spacer(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 10.dp)
                        .background(Color.LightGray, shape = RoundedCornerShape(10.dp))
                        .width(80.dp)
                        .size(2.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "winning Margin")
                Spacer(modifier = Modifier.width(10.dp))
                Spacer(
                    modifier = Modifier
                        .padding(end = 5.dp, top = 10.dp)
                        .background(Color.LightGray, shape = RoundedCornerShape(10.dp))
                        .width(80.dp)
                        .size(2.dp)
                )


            }

            Row(
                modifier = Modifier.padding(top = 130.dp, bottom = 10.dp)
            ) {
                Card(

                    modifier = Modifier
                        .height(34.dp)
                        .width(150.dp)
                        .padding(start = 14.dp),
                    backgroundColor = Color.White,
                    shape = RoundedCornerShape(20.dp)
                ) {

                    Text(
                        modifier = Modifier
                            .padding(start = 15.dp, top = 5.dp),
                        color = Color.Black,
                        text = "hornets " + "by" + "1" + "5"
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Image(

                        painter = painterResource(id = R.drawable.arrow_down_blue),
                        contentDescription = "",
                        modifier = Modifier.padding(start = 100.dp)

                    )

                }
                Spacer(modifier = Modifier.width(50.dp))
                Card(
                    modifier = Modifier
                        .height(34.dp)
                        .width(80.dp)
                        .padding(start = 5.dp),
                    backgroundColor = Color.White,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(

                        modifier = Modifier.padding(start = 20.dp, top = 5.dp),
                        text = "8.00",
                        color = Color.Black
                    )
                }
            }







    }

}

@Composable
fun GamesCard(games: Games) {
    Card(
        modifier = Modifier

            .padding(5.dp)
            .wrapContentWidth()

            .height(30.dp),
        elevation = 4.dp,
        backgroundColor = Color.Black,
        border = BorderStroke(1.5.dp,Color.DarkGray),
        shape = RoundedCornerShape(20.dp)


    ) {
        Row(

        ) {
            Image(

                painter = painterResource(games.id ),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 6.dp, start = 10.dp, end = 6.dp, bottom = 6.dp)
                    .size(20.dp)
                    .clip(shape = CircleShape)

            )
            Text(
                modifier = Modifier
                    .padding(start = 2.dp, top = 5.dp)
                    .wrapContentWidth(),
                color = Color.White,
                text = games.name
            )
            Spacer(modifier = Modifier.width(9.dp))
        }

    }

}

@Composable
fun GameEventSecondCard(){
    Card(

        elevation = 4.dp,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(8.dp)

    ){

    }
}

