package com.example.assignmentone.data.dto.lobby

data class Fixture(
    val competition: Competition?=null,
    val finalGameContentList: List<FinalGameContent>?=null,
    val finalOptionMarkets: List<Any>?=null,
    val finalOutridgeGames: Any?=null,
    val fixtureId: String?=null,
    val name: String?=null,
    val participateContentList: List<ParticipateContent>?=null,
    val sport: Sport?=null,
    val stage: String?=null,
    val startTime: String?=null
)