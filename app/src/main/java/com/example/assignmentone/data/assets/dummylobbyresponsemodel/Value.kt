package com.example.assignmentone.data.assets.dummylobbyresponsemodel

data class Value(
    val content: String,
    val gameId: Int,
    val gridGroupingId: Any,
    val grouping: Grouping,
    val index: Int,
    val optionNames: List<String>,
    val resultList: List<Result>,
    val sixPackKey: String,
    val spread: Double
)