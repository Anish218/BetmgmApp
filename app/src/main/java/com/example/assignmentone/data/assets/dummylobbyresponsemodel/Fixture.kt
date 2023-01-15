package com.example.assignmentone.data.assets.dummylobbyresponsemodel

data class Fixture(
    val competition: Competition,
    val finalGameContentList: List<FinalGameContent>,
    val finalOptionMarkets: List<FinalOptionMarket>,
    val finalOutridgeGames: Any,
    val fixtureId: String,
    val name: String,
    val participateContentList: List<ParticipateContent>,
    val sport: Sport,
    val stage: String,
    val startTime: String
)