package com.example.jsend.jsendapi.response

data class ErrorResponse(
    val message: String,
    val code: Int? = null
) : JSendResponse("Error")