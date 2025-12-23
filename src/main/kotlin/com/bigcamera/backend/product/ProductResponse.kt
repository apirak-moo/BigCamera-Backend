package com.bigcamera.backend.product

import java.math.BigDecimal
import java.time.Instant
import java.util.UUID

data class ProductResponse(
    val id: UUID,
    val name: String,
    val description: String? = null,
    val price: BigDecimal = BigDecimal.ZERO,
    val details: MutableList<ProductResponse> = mutableListOf(),
    val createAt: Instant? = null,
    val updateAt: Instant? = null,
)
