package com.example.assignmentone.data.dto.sitecoreresponse

data class Item(
    val CacheDuration: Any,
    val ContentErrors: List<Any>,
    val Fields: List<Field>,
    val Id: String,
    val Items: List<Any>,
    val Key: String,
    val Language: String,
    val Name: String,
    val ParentId: String,
    val Path: String,
    val Template: String,
    val TemplateId: String,
    val ValidTo: Any,
    val Version: Int,
    val Warnings: Any
)