package com.example.assignmentone.domain.repository

import com.example.assignmentone.common.Resource
import com.example.assignmentone.data.dto.dynaconresponse.DynaconResponse
import com.example.assignmentone.domain.model.DynaconRequest
import retrofit2.Response

interface DynaconRepository {

    suspend fun getDynaconData(headers: Map<String,String>,dynaconRequest: DynaconRequest): Resource<DynaconResponse>


}