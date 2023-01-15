package com.example.assignmentone.data.Api

import com.example.assignmentone.data.dto.dynaconresponse.DynaconResponse
import com.example.assignmentone.domain.model.DynaconRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface DynaconApi {

    @POST("/V3/Batch.svc/")
    suspend fun getDynaconData(@HeaderMap headers: Map<String,String>, @Body dynaconRequest: DynaconRequest):Response<DynaconResponse>
}