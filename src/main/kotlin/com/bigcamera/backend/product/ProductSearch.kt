package com.bigcamera.backend.product

import java.math.BigDecimal

data class ProductSearch(
    val name: String? = null,
    val min: BigDecimal? = null,
    val max: BigDecimal? = null,
    val category: Int? = null
)
