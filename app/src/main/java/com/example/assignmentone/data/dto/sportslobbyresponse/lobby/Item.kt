package com.example.assignmentone.data.dto.lobby

data class Item(
    val activeChildren: List<Any>?=null,
    val children: List<Children>?=null,
    val mergeNavigation: Boolean?=null,
    val showCount: Boolean?=null,
    val title: String?=null
)