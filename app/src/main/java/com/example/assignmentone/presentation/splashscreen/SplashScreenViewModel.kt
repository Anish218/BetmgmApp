package com.example.assignmentone.presentation.splashscreen

import android.annotation.SuppressLint
import androidx.lifecycle.*
import com.example.assignmentone.data.dto.dynaconresponse.DynaconResponse
import com.example.assignmentone.domain.usecase.dynaconUseCase.FetchDynaconDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.assignmentone.common.Resource
import com.example.assignmentone.data.dto.sitecoreresponse.SiteCoreResponse
import com.example.assignmentone.domain.usecase.sitecoreusecase.FetchSiteCoreDataUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


@HiltViewModel
class SplashScreenViewModel @Inject constructor(private val fetchDynaconDataUseCase: FetchDynaconDataUseCase,
private val fetchSiteCoreDataUseCase: FetchSiteCoreDataUseCase) : ViewModel(){

private var dynaconApiSuccess=MutableLiveData<Boolean>(true)
    val isDynaconApiSuccess:LiveData<Boolean>
    get() = dynaconApiSuccess
    private var networkconnected=MutableLiveData<Boolean>(true)
    val isNetworkConnected:LiveData<Boolean>
        get() = networkconnected


    private var dynaconResponseData = MutableLiveData<DynaconResponse>()
    val dynaconResponseObserver: LiveData<DynaconResponse>
        get() = dynaconResponseData
    private var siteCoreResponseData = MutableLiveData<SiteCoreResponse>()
    val siteCoreResponseObserver: LiveData<SiteCoreResponse>
        get() = siteCoreResponseData
    fun changeNetworkState(state:Boolean){
        networkconnected.postValue(state)

    }

    @SuppressLint("SuspiciousIndentation")
    fun callDynaconAndSiteCoreApi() {

        viewModelScope.launch {
            CoroutineScope(Dispatchers.IO).launch {
                val result = async {  fetchDynaconDataUseCase.postDynaconData()}
               result.await()
                println("*******")
                if(result.getCompleted() is Resource.Success){

                 dynaconResponseData.postValue(result.getCompleted().data!!)
//                    dynaconApiSuccess.postValue(true)
//                    println("completed")
//                    val result2 = async {  fetchSiteCoreDataUseCase.getSiteCoreData()
//                    }
//                    siteCoreResponseData.postValue(result2.await())

                }
                else{
                    dynaconApiSuccess.postValue(false)



                }
            }


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