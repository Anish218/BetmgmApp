package com.example.assignmentone.data.repository

import com.example.assignmentone.common.BaseRepo
import com.example.assignmentone.common.Resource
import com.example.assignmentone.data.Api.LobbyApi
import com.example.assignmentone.data.dto.lobby.LobbyResponse
import com.example.assignmentone.domain.repository.SportsLobbyRepository
import com.google.gson.JsonObject
import retrofit2.Response
import javax.inject.Inject

class SportsLobbyRepositoryImpl @Inject constructor(
    private val api: LobbyApi
) : SportsLobbyRepository,BaseRepo() {
    override suspend fun getLobbyData(
        headers: Map<String, String>,
        lobbyrequest: JsonObject
    ): Resource<LobbyResponse> {

        return  safeApiCall {   api.getLobbyApi(headers,lobbyrequest)}
    }


}