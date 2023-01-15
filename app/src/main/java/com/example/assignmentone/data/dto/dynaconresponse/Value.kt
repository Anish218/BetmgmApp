package com.example.assignmentone.data.dto.dynaconresponse

import com.example.assignmentone.data.dto.dynaconresponse.Context

data class Value(
    val context: List<Context>,
    val priority: Int,
    val value: String
)