package com.bigcamera.backend.mappers

import com.bigcamera.backend.category.Category
import com.bigcamera.backend.category.CategoryResponse

fun Category.toCategoryResponse(): CategoryResponse {
    return CategoryResponse(
        id = this.id!!,
        name = this.name
    )
}

fun List<Category>.toListCategoryResponse(): List<CategoryResponse> {
    return map { it.toCategoryResponse() }
}