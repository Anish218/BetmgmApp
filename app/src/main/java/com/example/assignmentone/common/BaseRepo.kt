package com.example.assignmentone.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

abstract class BaseRepo() {

    // we'll use this function in all
    // repos to handle api errors.
    suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): Resource<T> {

        // Returning api response
        // wrapped in Resource class
        return withContext(Dispatchers.IO) {
            try {

                val response: Response<T> = apiToBeCalled()

                if (response.isSuccessful) {
                    Resource.Success(data = response.body()!!)
                } else {

                    //val errorResponse: ExampleErrorResponse? = convertErrorBody(response.errorBody())
                    Resource.Error(message = response.errorBody().toString()?: "Something went wrong")
                }

            } catch (e: HttpException) {
                Resource.Error(message = e.message ?: "Something went wrong")
            } catch (e: IOException) {

                Resource.Error("Please check your network connection")
            } catch (e: Exception) {
                Resource.Error(message = "Something went wrong")
            }
        }
    }


}
