package com.example.assignmentone.presentation.viewModel

import android.app.Activity
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignmentone.MainActivity
import com.example.assignmentone.data.dto.lobby.Fixture

class MainViewModel : ViewModel(){
    private var bottomBarStatus=MutableLiveData<Boolean>(false)
    val isbottomBarStatus: LiveData<Boolean>
        get() = bottomBarStatus
    var splashScreenLoaded = mutableStateOf (true)
    private var screenshowing=MutableLiveData<Int>(com.example.assignmentone.R.id.sportsFragment)
    val whichscreenshowing:LiveData<Int>
    get() = screenshowing
    fun changescreen(id:Int){
        screenshowing.postValue(id)
    }
    fun changeBottomBarStatus(state:Boolean){
        bottomBarStatus.postValue(state)

    }

}