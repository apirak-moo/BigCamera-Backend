package com.bigcamera.backend.product

import java.util.UUID

data class ProductDetailResponse(
    val id: UUID,
    val name: String,
    val value: String,
)
