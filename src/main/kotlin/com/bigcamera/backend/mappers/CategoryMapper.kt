package com.bigcamera.backend.mappers

import com.bigcamera.backend.category.Category
import com.bigcamera.backend.category.CategoryResponse

fun Category.toCategoryResponse(category: Category): CategoryResponse {
    return CategoryResponse(
        id = category.id!!,
        name = category.name
    )
}

fun Category.toListCategoryResponse(categories: List<Category>): List<CategoryResponse> {
    return categories.map { toCategoryResponse(it) }
}