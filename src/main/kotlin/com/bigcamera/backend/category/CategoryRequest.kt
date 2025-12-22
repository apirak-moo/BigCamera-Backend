package com.bigcamera.backend.category

import jakarta.validation.constraints.NotBlank

data class CategoryRequest(
    @NotBlank(message = "Category cannot be blank")
    val name: String,
)
