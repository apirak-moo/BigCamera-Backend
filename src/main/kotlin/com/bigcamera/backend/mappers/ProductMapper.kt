package com.bigcamera.backend.mappers

import com.bigcamera.backend.product.Product
import com.bigcamera.backend.product.ProductDetail
import com.bigcamera.backend.product.ProductDetailResponse
import com.bigcamera.backend.product.ProductResponse

fun Product.toResponse(): ProductResponse {
    return ProductResponse(
        id = this.id!!,
        name = this.name,
        description = this.description,
        price = this.price,
    )
}

fun List<Product>.toResponse(): List<ProductResponse> {
    return map { it.toResponse() }
}

fun ProductDetail.toResponse(): ProductDetailResponse {
    return ProductDetailResponse(
        id = this.id!!,
        name = this.name,
        value = this.value,
    )
}

fun List<ProductDetail>.toResponse(): List<ProductDetailResponse> {
    return map { it.toResponse() }
}