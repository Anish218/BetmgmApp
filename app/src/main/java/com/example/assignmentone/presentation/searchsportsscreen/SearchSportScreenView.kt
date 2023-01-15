package com.example.assignmentone.presentation.searchsportsscreen

import android.content.Context
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignmentone.R

@Composable
fun SearchSportScreenView(
    searchSportScreenViewModel: SearchSportScreenViewModel,
    kFunction1: (Context) -> Unit,
    kFunction0: () -> Unit
) {
    var context = LocalContext.current
    val textSpeech by searchSportScreenViewModel.outputText.observeAsState()
    val searchedList by searchSportScreenViewModel.searchListData.observeAsState()

    println("ajkcad" + textSpeech)
    var text = remember { mutableStateOf("") }






    text.value = textSpeech.toString()
    println("text" + text.value)

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .background(colorResource(id = R.color.dull_gray))

                .fillMaxWidth()
        ) {
            Text(
                text = "Search",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 150.dp, bottom = 5.dp, top = 7.dp)
            )
            Spacer(modifier = Modifier.width(90.dp))
            Button(

                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(R.color.dull_gray),
                    contentColor = Color.Black
                ),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(55.dp),


                onClick = {

                    kFunction0()


                }
            ) {
                Text(text = "Close")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Card(
                modifier = Modifier
                    .padding(start = 15.dp, end = 13.dp)
                    .height(40.dp)
                    .fillMaxWidth()
                    .clickable(onClick = { }),
                backgroundColor = colorResource(id = R.color.white),
                border = BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(
                    modifier = Modifier.padding(start = 10.dp, top = 5.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.ic_baseline_keyboard_voice_24),
                        contentDescription = "",
                        modifier = Modifier.clickable(onClick = { kFunction1(context) })
                    )
                }

                Column(
                    modifier = Modifier.padding(start = 50.dp)
                ) {

                    textSpeech?.let {
                        BasicTextField(

                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxSize(),
                            value = it,

                            onValueChange = {

                                searchSportScreenViewModel.changetextSpeech(it)
//                                searchSportScreenViewModel.updateSearchedList(it)



                                println("it" + it)
                                //                            text.value = it
                                println("textcahnge" + text.value)


                            }
                        , onTextLayout = {
                                println("@@@@@@@@"+it.layoutInput.text)
                                searchSportScreenViewModel.updateSearchedList(it.layoutInput.text.toString())

                            }
                        )
                    }


                }


            }
        }

          if(text.value!=""){
              LazyColumn(modifier = Modifier.padding(start = 15.dp)) {
              Log.d("SearchView", "SearchSportScreenView: " + searchedList?.size)
              items(searchedList!!)
              { item ->
                  Searches(item)
              }
          }



        }


    }

}


@Composable
fun Searches(result: String) {


    Column(modifier = Modifier.padding(top=5.dp)
    ) {


        Row()
        {


            Row(modifier = Modifier.weight(1f))
            {

            Text(text = result, fontWeight=FontWeight.Bold)
            }
            Row(modifier = Modifier.weight(1f)) {
                Image(
                    painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24),
                    contentDescription = "",
                    modifier = Modifier.padding(start = 150.dp),
                )
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        Spacer(
            modifier = Modifier
                .padding(end = 15.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.LightGray)
        )
    }
}





