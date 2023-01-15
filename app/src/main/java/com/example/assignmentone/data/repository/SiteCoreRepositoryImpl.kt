package com.example.assignmentone.data.repository

import com.example.assignmentone.data.Api.DynaconApi
import com.example.assignmentone.data.Api.SiteCoreApi
import com.example.assignmentone.data.dto.dynaconresponse.DynaconResponse
import com.example.assignmentone.data.dto.sitecoreresponse.SiteCoreResponse
import com.example.assignmentone.domain.model.DynaconRequest
import com.example.assignmentone.domain.repository.DynaconRepository
import com.example.assignmentone.domain.repository.SiteCoreRepository
import javax.inject.Inject

class SiteCoreRepositoryImpl @Inject constructor(
    private val api: SiteCoreApi
) : SiteCoreRepository {
    override suspend fun getSiteCoredata(headers: Map<String, String>): SiteCoreResponse {
        return api.getSiteCoreData(headers)
    }


}