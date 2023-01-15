package com.example.assignmentone.presentation.sportsscreen

import android.annotation.SuppressLint
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentone.common.Resource
import com.example.assignmentone.data.dto.lobby.Fixture
import com.example.assignmentone.data.dto.lobby.LobbyResponse
import com.example.assignmentone.data.dto.lobby.Widget
import com.example.assignmentone.domain.usecase.SportsLobbyUseCase.FetchSportsLobbyDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SportsScreenViewModel @Inject constructor(private val fetchSportsLobbyDataUseCase: FetchSportsLobbyDataUseCase,
): ViewModel() {
    private var fixture=MutableLiveData<List<Fixture>>()
            val fixtures: MutableLiveData<List<Fixture>>
            get() = fixture
    private var lobbyApiSuccess=MutableLiveData<Boolean>(true)
    val isLobbyApiSuccess:LiveData<Boolean>
        get() = lobbyApiSuccess
    private var shimmerAnimation=MutableLiveData<Boolean>(true)
    val showShimmerAnimation:LiveData<Boolean>
    get()=shimmerAnimation


    private var dailog=MutableLiveData<Boolean>(false)
    val showDailog:LiveData<Boolean>
        get() = dailog
    fun changeDailogState(state:Boolean){
        dailog.postValue(state)

    }
    fun changeShimmerAnimation(state:Boolean){
        shimmerAnimation.postValue(state)

    }
    private var lobbyResponseData = MutableLiveData<LobbyResponse>()
    val lobbyResponseObserver: LiveData<LobbyResponse>
        get() = lobbyResponseData


    @SuppressLint("SuspiciousIndentation")
    fun callLobbyApi() {

        viewModelScope.launch {
            CoroutineScope(Dispatchers.IO).launch {
                val result = async {  fetchSportsLobbyDataUseCase.postLobbyData()}
              println("result"+  result.await().message)
//                //println("*******"+result.getCompleted().data)
                if(result.getCompleted() is Resource.Success){
                //shimmerAnimation.postValue(false)
                    println("lobby api is truee");
                    lobbyApiSuccess.postValue(true)


                }
                else{
                   // println("!!!!!"+result.getCompleted().message)
                    lobbyApiSuccess.postValue(false)
                    changeDailogState(true)


                }
            }

        }
    }
    fun getFixturesForMarquee(requireActivity: FragmentActivity) {
       fixture.postValue( fetchSportsLobbyDataUseCase.getFixturesForMarquee(requireActivity))

    }
}