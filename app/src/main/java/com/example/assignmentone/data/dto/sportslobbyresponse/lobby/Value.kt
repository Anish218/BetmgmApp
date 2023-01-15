package com.example.assignmentone.data.dto.lobby

data class Value(
    val content: String?=null,
    val gameId: Int?=null,
    val gridGroupingId: Any?=null,
    val grouping: Grouping?=null,
    val index: Int?=null,
    val optionNames: List<String>?=null,
    val resultList: List<Result>?=null,
    val sixPackKey: String?=null,
    val spread: Double?=null
)