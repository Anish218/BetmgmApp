package com.example.assignmentone.data.repository

import com.example.assignmentone.common.BaseRepo
import com.example.assignmentone.common.Resource
import com.example.assignmentone.data.Api.DynaconApi
import com.example.assignmentone.data.dto.dynaconresponse.DynaconResponse
import com.example.assignmentone.domain.model.DynaconRequest
import com.example.assignmentone.domain.repository.DynaconRepository
import retrofit2.Response
import javax.inject.Inject

class DynaconRepositoryImpl @Inject constructor(
    private val api: DynaconApi
) : DynaconRepository , BaseRepo() {



   override suspend fun getDynaconData(headers: Map<String, String>, dynaconRequest: DynaconRequest): Resource<DynaconResponse>  {
       return  safeApiCall {  api.getDynaconData(headers,dynaconRequest)}
   }
}