package com.example.jsend.jsendapi.controller



import com.example.jsend.jsendapi.response.ErrorResponse
import com.example.jsend.jsendapi.response.FailResponse
import com.example.jsend.jsendapi.response.SuccessResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class JSendController {

    @GetMapping("/success")
    fun getSuccess(): ResponseEntity<SuccessResponse<Map<String, String>>> {
        val data = mapOf("message" to "Operación exitosa")
        return ResponseEntity.ok(SuccessResponse(data))
    }

    @GetMapping("/fail")
    fun getFail(): ResponseEntity<FailResponse> {
        val data = mapOf("reason" to "Error en la validación de datos")
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(FailResponse(data))
    }

    @GetMapping("/error")
    fun getError(): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ErrorResponse("Ocurrió un error inesperado", 500))
    }
}