package com.example.assignmentone.domain.usecase.SportsLobbyUseCase

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.assignmentone.common.Resource
import com.example.assignmentone.data.Api.LobbyBodyService
import com.example.assignmentone.data.dto.lobby.Fixture
import com.example.assignmentone.data.dto.lobby.LobbyResponse
import com.example.assignmentone.data.dto.lobby.Payload
import com.example.assignmentone.data.dto.lobby.Widget
import com.example.assignmentone.domain.Utils
import com.example.assignmentone.domain.repository.SportsLobbyRepository
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import retrofit2.Response
import javax.inject.Inject

class FetchSportsLobbyDataUseCase  @Inject constructor(private val repository: SportsLobbyRepository) {
    private var fixtures = MutableLiveData<List<Fixture>?>()
    val showfixtures: MutableLiveData<List<Fixture>?>
        get() = fixtures

    suspend fun postLobbyData(): Resource<LobbyResponse> {

        val headers = mapOf(
            "x-bwin-accessId" to "YTM0ZGJhMWEtZjA5YS00NjI3LTk5NTctNzliM2JlMGExMzQw",
            "Environment" to "Qa2"
        )

        val lobbyrequest = JsonObject()
        lobbyrequest.addProperty("query", LobbyBodyService.lobbyQuery)

        val response = repository.getLobbyData(headers, lobbyrequest)
        val lists = response.data?.data?.lobbyResponse?.widgets
        if (lists != null) {

        }
        return response


    }

    fun getFixturesForMarquee(context: FragmentActivity): List<Fixture>? {
        val jsonFileString = Utils().getJsonDataFromAsset(context, "lobby.json")
        val listPersonType = object : TypeToken<LobbyResponse>() {}.type
        val widgets = Gson().fromJson<LobbyResponse?>(
            jsonFileString,
            listPersonType
        ).data?.lobbyResponse?.widgets
        var payload:Payload?=null

        for (widget in widgets!!) {
                if (widget.type == "Marquee")
                     payload = widget.payload
            }
        return payload?.fixtures

    }

}