package com.example.assignmentone.data.assets.dummylobbyresponsemodel

data class Payload(
    val fixtures: List<Fixture>,
    val items: Any,
    val marketGroups: MarketGroups,
    val navigation: List<Navigation>,
    val primaryActiveNavigation: String
)