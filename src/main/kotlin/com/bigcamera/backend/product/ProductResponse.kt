package com.bigcamera.backend.product

import java.math.BigDecimal
import java.time.Instant
import java.util.UUID

data class ProductResponse(
    val id: UUID,
    val name: String,
    val description: String? = null,
    val price: BigDecimal = BigDecimal.ZERO,
    val details: List<ProductDetailResponse> = listOf(),
    val createAt: Instant? = null,
    val updateAt: Instant? = null,
)
