package com.example.assignmentone.data.dto.lobby

data class Payload(
    val fixtures: List<Fixture>?=null,
    val items: List<Item>?=null,
    val marketGroups: MarketGroups?=null,
    val navigation: List<Navigation>?=null,
    val primaryActiveNavigation: String?=null
)