package com.bigcamera.backend.category

import jakarta.validation.constraints.NotBlank

data class CategorySearch(
    @NotBlank(message = "name is not blank.")
    var name: String? = null,
)
