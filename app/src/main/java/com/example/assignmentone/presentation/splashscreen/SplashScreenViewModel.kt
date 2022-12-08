package com.example.assignmentone.presentation.splashscreen

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.assignmentone.common.Resource
import com.example.assignmentone.data.dto.DynaconResponse
import com.example.assignmentone.domain.usecase.dynaconUseCase.FetchDynaconDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.assignmentone.domain.usecase.dynaconUseCase.UseCaseResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.reflect.Type
import java.util.concurrent.CancellationException


@HiltViewModel
class SplashScreenViewModel @Inject constructor(private val fetchDynaconDataUseCase: FetchDynaconDataUseCase) : ViewModel(){



    private var dynaconResponseData = MutableLiveData<DynaconResponse>()
    val dynaconResponseObserver: LiveData<DynaconResponse>
        get() = dynaconResponseData


    @SuppressLint("SuspiciousIndentation")
    fun getDynaconData() {

        viewModelScope.launch {
            val result = fetchDynaconDataUseCase.postDynaconData()
                dynaconResponseData.postValue(result)

//            fetchDynaconDataUseCase.invoke(scope = viewModelScope, onResult = object :
//                IDynaconApiUseCaseResponse {
//
//                override fun onSuccess(result: DynaconResponse) {
//                    Timber.e("Dynacon API--->$result")
//                    dynaconResponseData.postValue(result)
//                }
//
//                override fun onError(apiError: ApiError?) {
//                }
//            })
        }
    }


}