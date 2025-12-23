package com.bigcamera.backend.product

import jakarta.validation.constraints.NotBlank

data class ProductDetailRequest(

    @NotBlank(message = "name is not blank.")
    val name: String,

    @NotBlank(message = "value is not blank.")
    val value: String

)
