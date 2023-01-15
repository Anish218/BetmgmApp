package com.example.assignmentone.data.Api

import com.example.assignmentone.data.dto.dynaconresponse.DynaconResponse
import com.example.assignmentone.data.dto.sitecoreresponse.SiteCoreResponse
import com.example.assignmentone.domain.model.DynaconRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface SiteCoreApi {
    @GET("/V3/content.svc/cms/V5/clients/nj.playmgm.com/common/gvcsdk/regulatorystrings?environment=Prod&lang=en")
    suspend fun getSiteCoreData(@HeaderMap headers: Map<String,String>):SiteCoreResponse

}