package com.example.assignmentone.domain.usecase.sitecoreusecase

import com.example.assignmentone.data.dto.dynaconresponse.DynaconResponse
import com.example.assignmentone.data.dto.sitecoreresponse.SiteCoreResponse
import com.example.assignmentone.domain.model.DynaconRequest
import com.example.assignmentone.domain.model.EntriesRequest
import com.example.assignmentone.domain.repository.DynaconRepository
import com.example.assignmentone.domain.repository.SiteCoreRepository
import javax.inject.Inject

class FetchSiteCoreDataUseCase @Inject constructor(private val repository: SiteCoreRepository) {


    suspend fun getSiteCoreData(): SiteCoreResponse {

        val headers = mapOf(
            "x-bwin-accessId" to "ZDZjZjNlM2MtZTFjOC00MmQ0LWFhNGUtNzI4MjYxZWRjZmJi",
            "Accept" to "application/json",
            "Content-Type" to "application/json")


        return repository.getSiteCoredata(headers)
    }
}