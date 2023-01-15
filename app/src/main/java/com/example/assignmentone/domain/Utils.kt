package com.example.assignmentone.domain

import android.content.Context
import java.io.IOException

class Utils {
    fun getJsonDataFromAsset(context: Context?, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context?.assets?.open(fileName)?.bufferedReader().use { it?.readText().toString() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}