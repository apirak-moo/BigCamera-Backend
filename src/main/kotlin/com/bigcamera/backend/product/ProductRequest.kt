package com.bigcamera.backend.product

import java.math.BigDecimal

data class ProductRequest(
    val name: String,
    val description: String? = null,
    val price: BigDecimal = BigDecimal.ZERO,
    val categoryId: Int,
    val details: MutableList<ProductDetailRequest>? = null
)
