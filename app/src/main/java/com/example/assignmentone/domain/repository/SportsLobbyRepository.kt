package com.example.assignmentone.domain.repository

import com.example.assignmentone.common.Resource
import com.example.assignmentone.data.dto.lobby.LobbyResponse
import com.google.gson.JsonObject
import retrofit2.Response

interface SportsLobbyRepository   {

    suspend fun getLobbyData(headers: Map<String,String>,lobbyrequest: JsonObject): Resource<LobbyResponse>


}