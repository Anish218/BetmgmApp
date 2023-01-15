package com.example.assignmentone.data.dto.lobby

data class MarketGroups(
    val groups: List<Group>?=null,
    val sixPackGroups: List<SixPackGroup>?=null,
    val sportId: Int?=null
)