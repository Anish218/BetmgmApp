package com.example.assignmentone.presentation.searchsportsscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

class SearchSportScreenViewModel:ViewModel() {
    private var list = listOf("Mississippi State","Illinois","Tulane","USC","Purdue","LSU",
        "Utah","Penn State","Buffalo Bills","Cincinnati Bengals","Phoenix Suns",
        "New York Knicks","Los Angeles Lakers","Charlotte Hornets",
        "Chicago Bulls","Cleveland Cavaliers","Toronto Raptors","Indiana Pacers")
//     var searchList= mutableStateOf<List<String>>(listOf())
    var searchList=MutableLiveData<List<String>>(listOf())
     val searchListData:LiveData<List<String>>
         get() {
             return searchList
         }

    private var textSpeech= MutableLiveData<String>("")
    val outputText: LiveData<String>
        get() = textSpeech
    fun changetextSpeech(text:String){
        println("underxhange"+text)

        textSpeech.postValue(text)
        updateSearchedList(text)
    }
    fun updateSearchedList(text:String){

            println("updated")
            searchList.value = emptyList()
            println(searchList.value)
            println("underxhange" + text)
            val updatedList = list.filter {
                // it==text
                it.contains(text, ignoreCase = true)

            }
            println("updatelist" + updatedList)
//        searchList.value=updatedList
            searchList.postValue(updatedList)
            println("mutable list" + searchList.value)

    }
}
