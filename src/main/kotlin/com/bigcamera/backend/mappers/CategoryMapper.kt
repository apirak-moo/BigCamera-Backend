package com.bigcamera.backend.mappers

import com.bigcamera.backend.category.Category
import com.bigcamera.backend.category.CategoryResponse

fun Category.toResponse(): CategoryResponse {
    return CategoryResponse(
        id = this.id!!,
        name = this.name
    )
}

fun List<Category>.toResponse(): List<CategoryResponse> {
    return map { it.toResponse() }
}