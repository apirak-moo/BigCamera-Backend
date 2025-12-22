package com.bigcamera.backend.exceptions

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFound(
        ex: NotFoundException,
        request: HttpServletRequest
    ): ProblemDetail {

        val problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND)
        problem.title = "Resource Not Found"
        problem.detail = ex.message
        problem.instance = request.requestURI.let { java.net.URI.create(it) }

        // extension fields (optional)
        problem.setProperty("errorCode", "CAT-404")

        return problem
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(
        ex: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ProblemDetail {

        val errors = ex.bindingResult.fieldErrors
            .associate { it.field to (it.defaultMessage ?: "invalid") }

        val problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST)
        problem.title = "Validation Failed"
        problem.detail = "Request validation failed"
        problem.instance = java.net.URI.create(request.requestURI)
        problem.setProperty("errors", errors)

        return problem
    }

    @ExceptionHandler(Exception::class)
    fun handleGeneric(
        ex: Exception,
        request: HttpServletRequest
    ): ProblemDetail {

        val problem = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        problem.title = "Internal Server Error"
        problem.detail = ex.message
        problem.instance = java.net.URI.create(request.requestURI)

        return problem
    }

}