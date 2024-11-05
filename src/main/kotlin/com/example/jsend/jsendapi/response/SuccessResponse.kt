package com.example.jsend.jsendapi.response

data class SuccessResponse<T> (
    val data : T
) : JSendResponse("Successful response")
