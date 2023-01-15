package com.example.assignmentone.domain.repository

import com.example.assignmentone.data.dto.dynaconresponse.DynaconResponse
import com.example.assignmentone.data.dto.sitecoreresponse.SiteCoreResponse
import com.example.assignmentone.domain.model.DynaconRequest

interface SiteCoreRepository {

    suspend fun getSiteCoredata(headers: Map<String,String>): SiteCoreResponse


}