package com.example.assignmentone.data.Api

import com.example.assignmentone.data.dto.lobby.LobbyResponse
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface LobbyApi {
    @POST("/graphql")
    suspend fun getLobbyApi(@HeaderMap headers: Map<String,String>, @Body lobbyRequest: JsonObject): Response<LobbyResponse>

}